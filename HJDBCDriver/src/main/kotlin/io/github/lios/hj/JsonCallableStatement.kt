package io.github.lios.hj

import java.io.InputStream
import java.io.Reader
import java.math.BigDecimal
import java.net.URL
import java.sql.Array
import java.sql.Blob
import java.sql.CallableStatement
import java.sql.Clob
import java.sql.Date
import java.sql.NClob
import java.sql.Ref
import java.sql.RowId
import java.sql.SQLXML
import java.sql.Time
import java.sql.Timestamp
import java.util.Calendar

open class JsonCallableStatement: JsonPrepareStatement(), CallableStatement {
    override fun registerOutParameter(parameterIndex: Int, sqlType: Int) {
        TODO("Not yet implemented")
    }

    override fun registerOutParameter(parameterIndex: Int, sqlType: Int, scale: Int) {
        TODO("Not yet implemented")
    }

    override fun wasNull(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getString(parameterIndex: Int): String? {
        TODO("Not yet implemented")
    }

    override fun getBoolean(parameterIndex: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getByte(parameterIndex: Int): Byte {
        TODO("Not yet implemented")
    }

    override fun getShort(parameterIndex: Int): Short {
        TODO("Not yet implemented")
    }

    override fun getInt(parameterIndex: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getLong(parameterIndex: Int): Long {
        TODO("Not yet implemented")
    }

    override fun getFloat(parameterIndex: Int): Float {
        TODO("Not yet implemented")
    }

    override fun getDouble(parameterIndex: Int): Double {
        TODO("Not yet implemented")
    }

    override fun getBigDecimal(parameterIndex: Int, scale: Int): BigDecimal? {
        TODO("Not yet implemented")
    }

    override fun getBytes(parameterIndex: Int): ByteArray? {
        TODO("Not yet implemented")
    }

    override fun getDate(parameterIndex: Int): Date? {
        TODO("Not yet implemented")
    }

    override fun getTime(parameterIndex: Int): Time? {
        TODO("Not yet implemented")
    }

    override fun getTimestamp(parameterIndex: Int): Timestamp? {
        TODO("Not yet implemented")
    }

    override fun getObject(parameterIndex: Int): Any? {
        TODO("Not yet implemented")
    }

    override fun getBigDecimal(parameterIndex: Int): BigDecimal? {
        TODO("Not yet implemented")
    }

    override fun getObject(
        parameterIndex: Int,
        map: Map<String?, Class<*>?>?
    ): Any? {
        TODO("Not yet implemented")
    }

    override fun getRef(parameterIndex: Int): Ref? {
        TODO("Not yet implemented")
    }

    override fun getBlob(parameterIndex: Int): Blob? {
        TODO("Not yet implemented")
    }

    override fun getClob(parameterIndex: Int): Clob? {
        TODO("Not yet implemented")
    }

    override fun getArray(parameterIndex: Int): Array? {
        TODO("Not yet implemented")
    }

    override fun getDate(parameterIndex: Int, cal: Calendar?): Date? {
        TODO("Not yet implemented")
    }

    override fun getTime(parameterIndex: Int, cal: Calendar?): Time? {
        TODO("Not yet implemented")
    }

    override fun getTimestamp(parameterIndex: Int, cal: Calendar?): Timestamp? {
        TODO("Not yet implemented")
    }

    override fun registerOutParameter(parameterIndex: Int, sqlType: Int, typeName: String?) {
        TODO("Not yet implemented")
    }

    override fun registerOutParameter(parameterName: String?, sqlType: Int) {
        TODO("Not yet implemented")
    }

    override fun registerOutParameter(parameterName: String?, sqlType: Int, scale: Int) {
        TODO("Not yet implemented")
    }

    override fun registerOutParameter(parameterName: String?, sqlType: Int, typeName: String?) {
        TODO("Not yet implemented")
    }

    override fun getURL(parameterIndex: Int): URL? {
        TODO("Not yet implemented")
    }

    override fun setURL(parameterName: String?, `val`: URL?) {
        TODO("Not yet implemented")
    }

    override fun setNull(parameterName: String?, sqlType: Int) {
        TODO("Not yet implemented")
    }

    override fun setBoolean(parameterName: String?, x: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setByte(parameterName: String?, x: Byte) {
        TODO("Not yet implemented")
    }

    override fun setShort(parameterName: String?, x: Short) {
        TODO("Not yet implemented")
    }

    override fun setInt(parameterName: String?, x: Int) {
        TODO("Not yet implemented")
    }

    override fun setLong(parameterName: String?, x: Long) {
        TODO("Not yet implemented")
    }

    override fun setFloat(parameterName: String?, x: Float) {
        TODO("Not yet implemented")
    }

    override fun setDouble(parameterName: String?, x: Double) {
        TODO("Not yet implemented")
    }

    override fun setBigDecimal(parameterName: String?, x: BigDecimal?) {
        TODO("Not yet implemented")
    }

    override fun setString(parameterName: String?, x: String?) {
        TODO("Not yet implemented")
    }

    override fun setBytes(parameterName: String?, x: ByteArray?) {
        TODO("Not yet implemented")
    }

    override fun setDate(parameterName: String?, x: Date?) {
        TODO("Not yet implemented")
    }

    override fun setTime(parameterName: String?, x: Time?) {
        TODO("Not yet implemented")
    }

    override fun setTimestamp(parameterName: String?, x: Timestamp?) {
        TODO("Not yet implemented")
    }

    override fun setAsciiStream(parameterName: String?, x: InputStream?, length: Int) {
        TODO("Not yet implemented")
    }

    override fun setBinaryStream(parameterName: String?, x: InputStream?, length: Int) {
        TODO("Not yet implemented")
    }

    override fun setObject(
        parameterName: String?,
        x: Any?,
        targetSqlType: Int,
        scale: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun setObject(parameterName: String?, x: Any?, targetSqlType: Int) {
        TODO("Not yet implemented")
    }

    override fun setObject(parameterName: String?, x: Any?) {
        TODO("Not yet implemented")
    }

    override fun setCharacterStream(parameterName: String?, reader: Reader?, length: Int) {
        TODO("Not yet implemented")
    }

    override fun setDate(parameterName: String?, x: Date?, cal: Calendar?) {
        TODO("Not yet implemented")
    }

    override fun setTime(parameterName: String?, x: Time?, cal: Calendar?) {
        TODO("Not yet implemented")
    }

    override fun setTimestamp(parameterName: String?, x: Timestamp?, cal: Calendar?) {
        TODO("Not yet implemented")
    }

    override fun setNull(parameterName: String?, sqlType: Int, typeName: String?) {
        TODO("Not yet implemented")
    }

    override fun getString(parameterName: String?): String? {
        TODO("Not yet implemented")
    }

    override fun getBoolean(parameterName: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun getByte(parameterName: String?): Byte {
        TODO("Not yet implemented")
    }

    override fun getShort(parameterName: String?): Short {
        TODO("Not yet implemented")
    }

    override fun getInt(parameterName: String?): Int {
        TODO("Not yet implemented")
    }

    override fun getLong(parameterName: String?): Long {
        TODO("Not yet implemented")
    }

    override fun getFloat(parameterName: String?): Float {
        TODO("Not yet implemented")
    }

    override fun getDouble(parameterName: String?): Double {
        TODO("Not yet implemented")
    }

    override fun getBytes(parameterName: String?): ByteArray? {
        TODO("Not yet implemented")
    }

    override fun getDate(parameterName: String?): Date? {
        TODO("Not yet implemented")
    }

    override fun getTime(parameterName: String?): Time? {
        TODO("Not yet implemented")
    }

    override fun getTimestamp(parameterName: String?): Timestamp? {
        TODO("Not yet implemented")
    }

    override fun getObject(parameterName: String?): Any? {
        TODO("Not yet implemented")
    }

    override fun getBigDecimal(parameterName: String?): BigDecimal? {
        TODO("Not yet implemented")
    }

    override fun getObject(
        parameterName: String?,
        map: Map<String?, Class<*>?>?
    ): Any? {
        TODO("Not yet implemented")
    }

    override fun getRef(parameterName: String?): Ref? {
        TODO("Not yet implemented")
    }

    override fun getBlob(parameterName: String?): Blob? {
        TODO("Not yet implemented")
    }

    override fun getClob(parameterName: String?): Clob? {
        TODO("Not yet implemented")
    }

    override fun getArray(parameterName: String?): Array? {
        TODO("Not yet implemented")
    }

    override fun getDate(parameterName: String?, cal: Calendar?): Date? {
        TODO("Not yet implemented")
    }

    override fun getTime(parameterName: String?, cal: Calendar?): Time? {
        TODO("Not yet implemented")
    }

    override fun getTimestamp(parameterName: String?, cal: Calendar?): Timestamp? {
        TODO("Not yet implemented")
    }

    override fun getURL(parameterName: String?): URL? {
        TODO("Not yet implemented")
    }

    override fun getRowId(parameterIndex: Int): RowId? {
        TODO("Not yet implemented")
    }

    override fun getRowId(parameterName: String?): RowId? {
        TODO("Not yet implemented")
    }

    override fun setRowId(parameterName: String?, x: RowId?) {
        TODO("Not yet implemented")
    }

    override fun setNString(parameterName: String?, value: String?) {
        TODO("Not yet implemented")
    }

    override fun setNCharacterStream(parameterName: String?, value: Reader?, length: Long) {
        TODO("Not yet implemented")
    }

    override fun setNClob(parameterName: String?, value: NClob?) {
        TODO("Not yet implemented")
    }

    override fun setClob(parameterName: String?, reader: Reader?, length: Long) {
        TODO("Not yet implemented")
    }

    override fun setBlob(parameterName: String?, inputStream: InputStream?, length: Long) {
        TODO("Not yet implemented")
    }

    override fun setNClob(parameterName: String?, reader: Reader?, length: Long) {
        TODO("Not yet implemented")
    }

    override fun getNClob(parameterIndex: Int): NClob? {
        TODO("Not yet implemented")
    }

    override fun getNClob(parameterName: String?): NClob? {
        TODO("Not yet implemented")
    }

    override fun setSQLXML(parameterName: String?, xmlObject: SQLXML?) {
        TODO("Not yet implemented")
    }

    override fun getSQLXML(parameterIndex: Int): SQLXML? {
        TODO("Not yet implemented")
    }

    override fun getSQLXML(parameterName: String?): SQLXML? {
        TODO("Not yet implemented")
    }

    override fun getNString(parameterIndex: Int): String? {
        TODO("Not yet implemented")
    }

    override fun getNString(parameterName: String?): String? {
        TODO("Not yet implemented")
    }

    override fun getNCharacterStream(parameterIndex: Int): Reader? {
        TODO("Not yet implemented")
    }

    override fun getNCharacterStream(parameterName: String?): Reader? {
        TODO("Not yet implemented")
    }

    override fun getCharacterStream(parameterIndex: Int): Reader? {
        TODO("Not yet implemented")
    }

    override fun getCharacterStream(parameterName: String?): Reader? {
        TODO("Not yet implemented")
    }

    override fun setBlob(parameterName: String?, x: Blob?) {
        TODO("Not yet implemented")
    }

    override fun setClob(parameterName: String?, x: Clob?) {
        TODO("Not yet implemented")
    }

    override fun setAsciiStream(parameterName: String?, x: InputStream?, length: Long) {
        TODO("Not yet implemented")
    }

    override fun setBinaryStream(parameterName: String?, x: InputStream?, length: Long) {
        TODO("Not yet implemented")
    }

    override fun setCharacterStream(parameterName: String?, reader: Reader?, length: Long) {
        TODO("Not yet implemented")
    }

    override fun setAsciiStream(parameterName: String?, x: InputStream?) {
        TODO("Not yet implemented")
    }

    override fun setBinaryStream(parameterName: String?, x: InputStream?) {
        TODO("Not yet implemented")
    }

    override fun setCharacterStream(parameterName: String?, reader: Reader?) {
        TODO("Not yet implemented")
    }

    override fun setNCharacterStream(parameterName: String?, value: Reader?) {
        TODO("Not yet implemented")
    }

    override fun setClob(parameterName: String?, reader: Reader?) {
        TODO("Not yet implemented")
    }

    override fun setBlob(parameterName: String?, inputStream: InputStream?) {
        TODO("Not yet implemented")
    }

    override fun setNClob(parameterName: String?, reader: Reader?) {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getObject(parameterIndex: Int, type: Class<T?>?): T? {
        TODO("Not yet implemented")
    }

    override fun <T : Any?> getObject(parameterName: String?, type: Class<T?>?): T? {
        TODO("Not yet implemented")
    }
}