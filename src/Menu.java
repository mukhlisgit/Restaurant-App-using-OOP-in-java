public class Menu {
    private String[][] menuContents;


    public String[][] getMenuContents() {
        return menuContents;
    }

    public Menu() {
        this.menuContents = new String[][]{
                {"\t\t\t\t                             FULL MEALS                         "},
                {"\t\t\t\t     1.  Mexican chicken wrap                              35TL"},
                {"\t\t\t\t     2.  Bulgur and chicken wings                          29TL"},
                {"\t\t\t\t     3.  Dallas steak                                      65TL"},
                {"\t\t\t\t     4.  Ramen noodles                                     40TL"},
                {"\t\t\t\t     5.  Bolognese spaghetti                               42TL"},
                {"				                       BEVERAGES                         "},
                {"\t\t\t\t     6.  Apple juice                                        8TL"},
                {"\t\t\t\t     7.  Grape juice                                        8TL"},
                {"\t\t\t\t     8.  Watermelon shake                                  15TL"},
                {"\t\t\t\t ==============================================================="},
                {"\t\t\t\t          EXIT MENU                                             "},


        };


    }

}
