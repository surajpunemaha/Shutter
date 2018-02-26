package android.photoapp.shutter.Models;

public class Offer
{
    public String offer_id, offer_value, offer_name, offer_validity, photgrapher_name;

    public Offer() {
    }

    public Offer(String offer_id, String offer_value, String offer_name, String offer_validity, String photgrapher_name)
    {
        this.offer_id = offer_id;
        this.offer_value = offer_value;
        this.offer_name = offer_name;
        this.offer_validity = offer_validity;
        this.photgrapher_name = photgrapher_name;
    }

    public void setOffer_id(String offer_id) {
        this.offer_id = offer_id;
    }

    public void setOffer_value(String offer_value) {
        this.offer_value = offer_value;
    }

    public void setOffer_name(String offer_name) {
        this.offer_name = offer_name;
    }

    public void setOffer_validity(String offer_validity) {
        this.offer_validity = offer_validity;
    }

    public void setPhotgrapher_name(String photgrapher_name) {
        this.photgrapher_name = photgrapher_name;
    }

    public String getOffer_id() {
        return offer_id;
    }

    public String getOffer_value() {
        return offer_value;
    }

    public String getOffer_name() {
        return offer_name;
    }

    public String getOffer_validity() {
        return offer_validity;
    }

    public String getPhotgrapher_name() {
        return photgrapher_name;
    }
}
