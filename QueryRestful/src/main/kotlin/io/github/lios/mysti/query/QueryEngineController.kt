package io.github.lios.mysti.query

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import java.util.UUID

import javax.sql.DataSource;
import kotlin.io.path.Path
import kotlin.uuid.Uuid

@RestController
class QueryEngineController {
    @Autowired
    private val database: DataSource? = null

    @PostMapping("/query/sql")
    public fun sql(@RequestBody req: QueryRequest): QueryResponse {
        var connection = database?.connection
        var prepareStatement = connection?.prepareStatement(req.sql)
        var execute = prepareStatement?.execute()
        if (execute != null && execute) {
            var resultSet = prepareStatement?.resultSet
            var metaData = resultSet?.metaData
            val columnCount = metaData?.columnCount?: 0
            val good = (1..columnCount).associate {
                metaData?.getColumnLabel(it)!! to mapOf(
                    "type" to metaData?.getColumnTypeName(it)!!,
                    "autoIncrement" to metaData?.isAutoIncrement(it)!!,
                    "caseSensitive" to metaData?.isCaseSensitive(it)!!,
                    "searchable" to metaData?.isSearchable(it)!!,
                    "currency" to metaData?.isCurrency(it)!!,
                    "nullable" to metaData?.isNullable(it)!!,
                    "signed" to metaData?.isSigned(it)!!,
                    "columnDisplaySize" to metaData?.getColumnDisplaySize(it)!!,
                    "columnLabel" to metaData?.getColumnLabel(it)!!,
                    "columnName" to metaData?.getColumnName(it)!!,
                    "schemaName" to metaData?.getSchemaName(it)!!,
                    "precision" to metaData?.getPrecision(it)!!,
                    "scale" to metaData?.getScale(it)!!,
                    "tableName" to metaData?.getTableName(it)!!,
                    "catalogName" to metaData?.getCatalogName(it)!!,
                    "columnType" to metaData?.getColumnType(it)!!,
                    "columnTypeName" to metaData?.getColumnTypeName(it)!!,
                    "readOnly" to metaData?.isReadOnly(it)!!,
                    "writable" to metaData?.isWritable(it)!!,
                    "definitelyWritable" to metaData?.isDefinitelyWritable(it)!!,
                    "columnClassName" to metaData?.getColumnClassName(it)!!,
                )
            } ?: emptyMap()

            val rset = mutableListOf<Map<String, Any>>()
            while (resultSet?.next()!!) {
                val row = (1..columnCount).associate {
                    metaData?.getColumnLabel(it)!! to resultSet.getObject(it)
                }
                rset.add(row)
            }

            return QueryResponse().apply {
                retCode = 0
                retInfo = "SUCCESS"
                i18Key = ""
                data = QueryResult().apply {
                    columns =  good
                    results = rset.toList()
                    queryId = UUID.randomUUID().toString()
                    severity = ""
                    suggestion = ""
                }
            }
        }

        return QueryResponse()
    }
}

class QueryRequest {
    val sql: String? = null
}

class QueryResponse {
    var retCode: Int = 0
    var retInfo: String = "SUCCESS"
    var i18Key: String = ""
    var data: Any = Any()
}

class QueryResult {
    var columns: Map<String, Map<String, Any>> = emptyMap()
    var results: List<Map<String, Any>> = emptyList();
    var queryId: String = ""
    var severity: String = ""
    var suggestion: String = ""
}