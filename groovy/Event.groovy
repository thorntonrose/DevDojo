import java.sql.*

@GrabConfig(systemClassLoader=true)
@Grab(group='org.postgresql', module='postgresql', version='9.4-1205-jdbc42')

cli = new CliBuilder(usage: "Event <options>")
cli._ longOpt: "add", args: 1, argName: "text", "add event"
cli._ longOpt: "delete", args: 1, argName: "id", "delete event"
cli._ longOpt: "list", "list events"

opts = cli.parse(args)
if (! opts) { return }

if (!opts.add && !opts.delete && !opts.list) {
   cli.usage()
   return
}

tableName = "ttr_event"
Class.forName("org.postgresql.Driver")
conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "postgres", "")
statement = conn.createStatement()

try {
	initDb()

	if (opts.add) {
		addEvent()
	}

	if (opts.delete) {
		deleteEvent()
	}

	if (opts.list) {
		listEvents()
	}
} finally {
	conn.close()
}

//-----------------------------------------------------------------------------

def initDb() {
	def resultSet = conn.metaData.getTables(null, null, tableName, null)

	if (!resultSet.next()) {
		statement.execute("create table $tableName (id varchar primary key, text varchar, create_on timestamp)")
	}
}

def addEvent() {
	def id = (System.currentTimeMillis() + new Object().hashCode()) as String
	def createdOn = new Timestamp(System.currentTimeMillis())
	statement.execute("insert into $tableName values ('$id', '${opts.add}', '$createdOn')")
	println "$id, ${opts.add}, $createdOn"
}

def deleteEvent() {
	def count = statement.executeUpdate("delete from $tableName where id = '${opts.delete}'")
	if (count > 0) { println opts.delete }
}

def listEvents() {
	def resultSet = statement.executeQuery("select * from $tableName")

	while (resultSet.next()) {
		println([ resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3) ].join(", "))
	}
}