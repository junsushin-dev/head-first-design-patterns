package iterator;
import java.util.Iterator;
import java.util.List;

public class Waitress {
    List<Menu> menus;
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
