public class FactoryMethodPatternExample {

    // Document Interface
    interface Document {
        void open();
        void close();
        void save();
    }

    // WordDocument Class
    static class WordDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Word document...");
        }

        @Override
        public void close() {
            System.out.println("Closing Word document...");
        }

        @Override
        public void save() {
            System.out.println("Saving Word document...");
        }
    }

    // PdfDocument Class
    static class PdfDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening PDF document...");
        }

        @Override
        public void close() {
            System.out.println("Closing PDF document...");
        }

        @Override
        public void save() {
            System.out.println("Saving PDF document...");
        }
    }

    // ExcelDocument Class
    static class ExcelDocument implements Document {
        @Override
        public void open() {
            System.out.println("Opening Excel document...");
        }

        @Override
        public void close() {
            System.out.println("Closing Excel document...");
        }

        @Override
        public void save() {
            System.out.println("Saving Excel document...");
        }
    }

    // DocumentFactory Abstract Class
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // WordDocumentFactory Class
    static class WordDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }

    // PdfDocumentFactory Class
    static class PdfDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    // ExcelDocumentFactory Class
    static class ExcelDocumentFactory extends DocumentFactory {
        @Override
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Test Class
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}
