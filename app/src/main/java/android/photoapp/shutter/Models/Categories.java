package android.photoapp.shutter.Models;

public class Categories
{
    public String category_id, category_name, pic_url;

    public Categories() {

    }

    public Categories(String category_id, String category_name, String pic_url)
    {
        this.category_id = category_id;
        this.category_name = category_name;
        this.pic_url =pic_url;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}