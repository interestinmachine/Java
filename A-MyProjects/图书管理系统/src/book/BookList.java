package book;

public class BookList {
    private Book[] books = new Book[100];
    private int usedSize = 0;

    public BookList(){
        books[0] = new Book("aaa","111",19.9,"小说");
        books[1] = new Book("bbb","222",20.3,"科幻");
        books[2] = new Book("ccc","333",12.6,"写实");
        this.usedSize = 3;
    }
}

