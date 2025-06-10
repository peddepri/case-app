public class DataRecord {
    private Long id;
    private String name;
    private String temperament;
    private String origin;

    public DataRecord() {
    }

    public DataRecord(Long id, String name, String temperament, String origin) {
        this.id = id;
        this.name = name;
        this.temperament = temperament;
        this.origin = origin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}