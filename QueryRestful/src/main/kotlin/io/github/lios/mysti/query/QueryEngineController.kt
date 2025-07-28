package io.github.lios.mysti.query

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.sql.DataSource

@RestController
class QueryEngineController {
    @Autowired
    private val database: DataSource? = null

    @PostMapping("/query/sql")
    fun sql(@RequestBody req: QueryRequest): QueryResponse {
        database?.connection.use { con ->
            con?.prepareStatement(req.sql)!!.use { ps ->
                if (!ps.execute()) {
                    return QueryResponse().apply{
                        retCode = 1
                        retInfo = "FAILED"
                    }
                }

                ps.resultSet?.use { rs ->
                    val metaData = rs.metaData!!
                    val columnCount = metaData.columnCount
                    val columnMetas = (1..columnCount).associate {
                        metaData.getColumnLabel(it)!! to mapOf(
                            "type" to metaData.getColumnTypeName(it)!!,
                            "meta" to ColumnMeta(
                                autoIncrement =  metaData.isAutoIncrement(it),
                                caseSensitive =  metaData.isCaseSensitive(it),
                                searchable =  metaData.isSearchable(it),
                                currency =  metaData.isCurrency(it),
                                nullable =  metaData.isNullable(it),
                                signed =  metaData.isSigned(it),
                                columnDisplaySize =  metaData.getColumnDisplaySize(it),
                                columnLabel =  metaData.getColumnLabel(it)!!,
                                columnName =  metaData.getColumnName(it)!!,
                                schemaName =  metaData.getSchemaName(it)!!,
                                precision =  metaData.getPrecision(it),
                                scale =  metaData.getScale(it),
                                tableName =  metaData.getTableName(it)!!,
                                catalogName =  metaData.getCatalogName(it)!!,
                                columnType =  metaData.getColumnType(it),
                                columnTypeName =  metaData.getColumnTypeName(it)!!,
                                readOnly =  metaData.isReadOnly(it),
                                writable =  metaData.isWritable(it),
                                definitelyWritable =  metaData.isDefinitelyWritable(it),
                                columnClassName =  metaData.getColumnClassName(it)!!,
                            )
                        )
                    }

                    val rset = mutableListOf<Map<String, Any>>()
                    while (rs.next()) {
                        val row = (1..columnCount).associate {
                            metaData.getColumnLabel(it)!! to rs.getObject(it)
                        }
                        rset.add(row)
                    }

                    return QueryResponse().apply {
                        retCode = 0
                        retInfo = "SUCCESS"
                        i18Key = ""
                        data = QueryResult().apply {
                            columns =  columnMetas
                            results = rset.toList()
                            queryId = UUID.randomUUID().toString()
                            severity = ""
                            suggestion = ""
                        }
                    }
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
    var results: List<Any> = emptyList()
    var queryId: String = ""
    var severity: String = ""
    var suggestion: String = ""
}

data class ColumnMeta(
    val autoIncrement: Boolean,
    val caseSensitive: Boolean,
    val searchable: Boolean,
    val currency: Boolean,
    val nullable: Int,
    val signed: Boolean,
    val columnDisplaySize: Int,
    val columnLabel: String,
    val columnName: String,
    val schemaName: String,
    val precision: Int,
    val scale: Int,
    val tableName: String,
    val catalogName: String,
    val columnType: Int,
    val columnTypeName: String,
    val readOnly: Boolean,
    val writable: Boolean,
    val definitelyWritable: Boolean,
    val columnClassName: String,
)