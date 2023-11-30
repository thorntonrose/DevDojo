def words = []
System.in.eachLine { words += it.split("\\W") }
println words.flatten().sort()

/*
Reader reader = new BufferedReader(new InputStreamReader(System.in))
List words = new ArrayList()

try {
   while (true) {
      String line = reader.readLine()
      if (line == null) { break }
      words.addAll(line.split("\\W"))
   }
} finally {
   reader.close()
}

Collections.sort(words)
System.out.println(words)
*/