def reader = System.in.withReader {
   def line
   while ((line = it.readLine()) != null) { println line }
}