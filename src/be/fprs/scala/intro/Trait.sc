// Similar to interfaces in Java, traits are used to define object types by specifying the signature of the supported
// methods. Unlike Java, Scala allows traits to be partially implemented; i.e. it is possible to define default
// implementations for some methods. In contrast to classes, traits may not have constructor parameters.

// an abstract class DocumentAction is defined with a method readDocument. The document class inherits from the
// documentAction class and defines the readDocument method.
// two traits are defined ClassifiedDocumentFilter :: when containing the word classified the document is scrambled.
// CodeWordFilter trait defines when the word code is found in the document is will not be scrambled.
// by applying multiple traits with the word "with" we are doing trait chaining
// see below explanation of trait chaining in this example

// use case
// read a document with possibility to scramble classified documents upon reading. In case a code word "code" is
// found in the document then the document may not be scrambled.

abstract class DocumentAction {
  def readDocument(document : String)
}

class Document extends DocumentAction {
  val action = new StringBuilder
  def readDocument(document : String) = action.append(document)
  override def toString() = action.toString()
}

trait ClassifiedDocumentFilter extends DocumentAction {
  abstract override def readDocument(document : String): Unit = {
    if (document.contains("classified"))
      super.readDocument(document.replaceAll("[a-z,A-Z,0-9]","*"))
    else
    super.readDocument(document)
  }
}

trait CodeWordFilter extends DocumentAction {
  abstract override def readDocument(document : String): Unit = {
    if (document.contains("code"))
      super.readDocument(document.toUpperCase())
    else
      super.readDocument(document)
  }
}

def readClassifiedDocument(action : DocumentAction): Unit = {
  action.readDocument("This is a classified document. Everyone not subject to the classification"
    + " filter can read it. When a code is there we make an exception.")
  println(action)
}

def readPublicDocument(action : DocumentAction): Unit = {
  action.readDocument("This is a public document. Everyone may read this document restricted by "
    + "classification filter or not.")
  println(action)
}

// a classified document is read. Through the ClassifiedDocumentFilter the document is scrambled.
readClassifiedDocument(new Document with  ClassifiedDocumentFilter)
// trait chaining
// a classified document is read. With CodeWordFilter and ClassifiedDocumentFilter. When applying the CodeWordFilter
// the document should not be scrambled. Here codeWordFilter is executed first then the classifiedDocumentFilter.
// Since the order is from left to right the ClassifiedDocumentFilter is executed last and scrambles the document.
// this is not intended but demonstrates that the order of traits are executed from left to right
readClassifiedDocument(new Document with  CodeWordFilter with ClassifiedDocumentFilter)
// see here the correct chaining of our use case.
readClassifiedDocument(new Document with  ClassifiedDocumentFilter with CodeWordFilter)

