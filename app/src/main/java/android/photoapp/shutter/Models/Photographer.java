package android.photoapp.shutter.Models;

public class Photographer
{
    String p_id, p_name, p_url;

    public Photographer()
    {

    }

    public Photographer(String p_id, String p_name, String p_url)
    {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_url = p_url;
    }

    public String getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setP_url(String p_url) {
        this.p_url = p_url;
    }

    public String getP_url() {
        return p_url;
    }
}
