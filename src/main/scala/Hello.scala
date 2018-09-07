import java.io.{BufferedReader, File, FileReader}

object Hello extends App {
  Echo("Hello, World!").call()

  Echo(currentDirectoryPath()).call()
  println(printBuildSbtFile(currentDirectoryPath()))

  def currentDirectoryPath(): String = new File(".").getAbsoluteFile.getParent

  def printBuildSbtFile(projectRootPath: String): String = {
    val reader = new BufferedReader(new FileReader(new File(s"$projectRootPath/build.sbt")))
    reader.mkString("\n")


    // javaぽく
//    val stringBuilder = new StringBuilder
//    val reader = new BufferedReader(new FileReader(new File(s"$projectRootPath/build.sbt")))
//    var line = reader.readLine
//
//    while (line!=null) {
//      stringBuilder.append(line).append(System.lineSeparator())
//      line = reader.readLine
//    }
//
//    stringBuilder.toString()
  }

  implicit class IterableBufferedReader(bufferedReader: BufferedReader) extends Iterable[String] {
    override def iterator: Iterator[String] = Iterator.continually(bufferedReader.readLine()).takeWhile(_ != null)
  }
}

case class Echo(message: String) {
  def call() = {
    println(message)
  }
}