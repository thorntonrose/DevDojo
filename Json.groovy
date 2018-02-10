import com.fasterxml.jackson.databind.*

abstract class Json {
    static mapper = new ObjectMapper()

    static toJson(obj, pretty = true) {
        def writer = pretty ? mapper.writerWithDefaultPrettyPrinter() : mapper.writer()
        writer.writeValueAsString(obj)
    }

    static fromJson(String text, objClass = Map) {
        text ? mapper.readValue(text, objClass) : null
    }

    static void main(String[] args) {
        def map = Json.fromJson(args[0])
        println "map: $map"
        println "json: ${Json.toJson(map)}"
    }
}
