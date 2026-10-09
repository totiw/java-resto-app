
import java.util.Scanner;

class Menu {
  String name;
  int price;
  String category;

  Menu(String name, int price, String category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }
}

public class Main {
  static Scanner input = new Scanner(System.in);
  static int sub_total = 0;

  static Menu[] menu_list = {
      new Menu("Nasi Goreng", 25000, "Makanan"),
      new Menu("Mie Goreng", 20000, "Makanan"),
      new Menu("Ayam Geprek", 22000, "Makanan"),
      new Menu("Sate Ayam", 25000, "Makanan"),
      new Menu("Bakso", 20000, "Makanan"),

      new Menu("Es Teh", 5000, "Minuman"),
      new Menu("Es Jeruk", 8000, "Minuman"),
      new Menu("Kopi Hitam", 10000, "Minuman"),
      new Menu("Jus Alpukat", 15000, "Minuman"),
      new Menu("Air Mineral", 5000, "Minuman")
  };

  // mencari menu berdasarkan nama
  static Menu findMenu(String[] input_order) {
    if (input_order[0].equalsIgnoreCase(menu_list[0].name)) {
      return menu_list[0];
    } else if (input_order[0].equalsIgnoreCase(menu_list[1].name)) {
      return menu_list[1];
    } else if (input_order[0].equalsIgnoreCase(menu_list[2].name)) {
      return menu_list[2];
    } else if (input_order[0].equalsIgnoreCase(menu_list[3].name)) {
      return menu_list[3];
    } else if (input_order[0].equalsIgnoreCase(menu_list[4].name)) {
      return menu_list[4];
    } else if (input_order[0].equalsIgnoreCase(menu_list[5].name)) {
      return menu_list[5];
    } else if (input_order[0].equalsIgnoreCase(menu_list[6].name)) {
      return menu_list[6];
    } else if (input_order[0].equalsIgnoreCase(menu_list[7].name)) {
      return menu_list[7];
    } else if (input_order[0].equalsIgnoreCase(menu_list[8].name)) {
      return menu_list[8];
    } else if (input_order[0].equalsIgnoreCase(menu_list[9].name)) {
      return menu_list[9];
    }

    return null;
  }

  // membuat pesanan berdasarkan menu input user
  static String[] createOrder() {
    String[] input_order = input.nextLine().split("\\s*=\\s*");
    Menu selected_menu = findMenu(input_order);
    if (selected_menu == null) {
      return null;
    }
    return input_order;
  }

  // menampilkan daftar menu makanan dan minuman
  static void showMenu() {
    System.out.println("=========   List    =========");
    System.out.println("=========   Menu    =========");
    System.out.println("\n");
    System.out.println("--------- Makanan ---------");
    System.out.println(menu_list[0].name + " - Rp." + menu_list[0].price + " (" + menu_list[0].category + ")");
    System.out.println(menu_list[1].name + " - Rp." + menu_list[1].price + " (" + menu_list[1].category + ")");
    System.out.println(menu_list[2].name + " - Rp." + menu_list[2].price + " (" + menu_list[2].category + ")");
    System.out.println(menu_list[3].name + " - Rp." + menu_list[3].price + " (" + menu_list[3].category + ")");
    System.out.println(menu_list[4].name + " - Rp." + menu_list[4].price + " (" + menu_list[4].category + ")");
    System.out.println("\n");
    System.out.println("--------- Minuman ---------");
    System.out.println(menu_list[5].name + " - Rp." + menu_list[5].price + " (" + menu_list[5].category + ")");
    System.out.println(menu_list[6].name + " - Rp." + menu_list[6].price + " (" + menu_list[6].category + ")");
    System.out.println(menu_list[7].name + " - Rp." + menu_list[7].price + " (" + menu_list[7].category + ")");
    System.out.println(menu_list[8].name + " - Rp." + menu_list[8].price + " (" + menu_list[8].category + ")");
    System.out.println(menu_list[9].name + " - Rp." + menu_list[9].price + " (" + menu_list[9].category + ")");
    System.out.println("\n");
    System.out.println("\n");
  }

  // cetak struk pesanan
  static void printOrder(int no, String[] order) {
    Menu selected_menu = findMenu(order);
    int price = selected_menu.price;
    int qty = Integer.parseInt(order[1]);
    System.out.printf(no + ". " + "%s - Rp.%d x %d = %d%n", order[0], price, qty, price * qty);
    sub_total += price * qty;
  }

  // menerima dan mengolah pesanan
  static void prosesPesanan() {
    System.out.println("======== Masukkan Pesanan (Maksimal 4 menu) ========");
    System.out.print("Jumlah menu yang ingin dipesan: ");

    int jumlahPesanan = Integer.parseInt(input.nextLine());

    if (jumlahPesanan > 4) {
      System.out.println("Maksimal 4 menu yang bisa dipesan");
      return;
    }

    String[] pesanan1 = null;
    String[] pesanan2 = null;
    String[] pesanan3 = null;
    String[] pesanan4 = null;

    if (jumlahPesanan >= 1) {
      System.out.print("Masukkan menu 1: ");
      pesanan1 = createOrder();
    }
    if (jumlahPesanan >= 2) {
      System.out.print("Masukkan menu 2: ");
      pesanan2 = createOrder();
    }
    if (jumlahPesanan >= 3) {
      System.out.print("Masukkan menu 3: ");
      pesanan3 = createOrder();
    }
    if (jumlahPesanan >= 4) {
      System.out.print("Masukkan menu 4: ");
      pesanan4 = createOrder();
    }

    System.out.println("\n============= PESANAN =============");

    if (pesanan1 != null) {
      printOrder(1, pesanan1);
    }
    if (pesanan2 != null) {
      printOrder(2, pesanan2);
    }
    if (pesanan3 != null) {
      printOrder(3, pesanan3);
    }
    if (pesanan4 != null) {
      printOrder(4, pesanan4);
    }

    int tax = sub_total * 10 / 100;
    int diskon = sub_total > 100000 ? sub_total * 10 / 100 : 0;
    int admin_cost = 20000;
    int total = sub_total + tax + admin_cost - diskon;

    System.out.println("\n--------------TOTAL--------------");
    System.out.printf("Total Harga : Rp.%d,-%n", sub_total);
    System.out.printf("Biaya Admin : Rp.%d,-%n", admin_cost);
    System.out.printf("Tax (10%%)  : Rp.%d,-%n", tax);
    if (diskon > 0) {
      System.out.printf("Diskon (10%%) : Rp.%d,-%n", diskon);
    }
    System.out.printf("Total Bayar : Rp.%d,-%n", total);
  }

  // main function
  public static void main(String[] args) {
    showMenu();
    prosesPesanan();
  }
}