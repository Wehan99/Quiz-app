package uk.ac.westminster.mobilecw;

public class Photos {
    private int image;
    private String data;

    public Photos(int image, String data) {
        this.image = image;
        this.data = data;
    }

    public int getImage() {
        return image;
    }

    public String getData() {
        return data;
    }
}
