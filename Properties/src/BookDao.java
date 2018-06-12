public interface BookDao {
    /**
     * 更新书籍
     *
     * @param book 书籍
     * @return 是否更新成功
     */
    boolean updateBook(Book book);
}
