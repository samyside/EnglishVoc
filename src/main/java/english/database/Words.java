package english.database;

public class Words {
    // Поля класса
    private int id;
    private String eng;
    private String rus;

    // Конструктор
    Words(int id, String eng, String rus)
    {
        this.id = id;
        this.eng = eng;
        this.rus = rus;
    }

    @Override
    public String toString()
    {
        return String.format("ID: %s | \t%s -> \t%s ",
                this.id, this.eng, this.rus);
    }

    String getEng() { return this.eng; }

    String getRus() { return this.rus; }
}
