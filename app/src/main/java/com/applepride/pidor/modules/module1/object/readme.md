# Entities
Сюда впихивать именно дата-объекты

**Пример дата-класса:**
```
class Item {
    int id;
    String value;
    
    public Item(int id, String value) {
        this.id = id;
        this.value = value;
    }
    
    public int getId() {
        return id;
    }
    
    public String getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value + String.valueOf(id);
    }
}
```