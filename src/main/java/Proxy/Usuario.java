package Proxy;

public class Usuario {
    private boolean root;

    public Usuario(boolean root) {
        this.root = root;
    }

    public boolean isRoot() {
        return root;
    }

    public void setRoot(boolean root) {
        this.root = root;
    }
}
