
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

enum Category {
  Makanan,
  Minuman
}

class Menu {
  String name;
  int price;
  Category category;

  Menu(String name, int price, Category category) {
    this.name = name;
    this.price = price;
    this.category = category;
  }
}

public class Main {
  static Scanner input = new Scanner(System.in);
  static String[] pesanan1 = null;
  static String[] pesanan2 = null;
  static String[] pesanan3 = null;
  static String[] pesanan4 = null;
  static int jumlahPesanan = 0;
  static int sub_total = 0;

  static Menu[] menu = {
      new Menu("Nasi Goreng", 25000, Category.Makanan),
      new Menu("Mie Goreng", 20000, Category.Makanan),
      new Menu("Ayam Geprek", 22000, Category.Makanan),
      new Menu("Sate Ayam", 25000, Category.Makanan),
      new Menu("Bakso", 20000, Category.Makanan),

      new Menu("Es Teh", 5000, Category.Minuman),
      new Menu("Es Jeruk", 8000, Category.Minuman),
      new Menu("Kopi Hitam", 10000, Category.Minuman),
      new Menu("Jus Alpukat", 15000, Category.Minuman),
      new Menu("Air Mineral", 5000, Category.Minuman)
  };

  static String toIDR(int nominal) {
    NumberFormat formatter = NumberFormat.getInstance(new Locale("id", "ID"));
    return "Rp." + formatter.format(nominal);
  }

  // mencari menu berdasarkan nama
  static Menu findMenu(String[] input_order) {
    if (input_order[0].equalsIgnoreCase(menu[0].name)) {
      return menu[0];
    } else if (input_order[0].equalsIgnoreCase(menu[1].name)) {
      return menu[1];
    } else if (input_order[0].equalsIgnoreCase(menu[2].name)) {
      return menu[2];
    } else if (input_order[0].equalsIgnoreCase(menu[3].name)) {
      return menu[3];
    } else if (input_order[0].equalsIgnoreCase(menu[4].name)) {
      return menu[4];
    } else if (input_order[0].equalsIgnoreCase(menu[5].name)) {
      return menu[5];
    } else if (input_order[0].equalsIgnoreCase(menu[6].name)) {
      return menu[6];
    } else if (input_order[0].equalsIgnoreCase(menu[7].name)) {
      return menu[7];
    } else if (input_order[0].equalsIgnoreCase(menu[8].name)) {
      return menu[8];
    } else if (input_order[0].equalsIgnoreCase(menu[9].name)) {
      return menu[9];
    }

    return null;
  }

  static void showMenu() {
    showMenu(null);
  }

  // menampilkan daftar menu makanan dan minuman
  static void showMenu(Category category) {
    System.out.println("=========   List    =========");
    System.out.println("=========   Menu    =========");
    if (category == null || category == Category.Makanan) {
      System.out.println("\n");
      System.out.println("--------- Makanan ---------");
      System.out.println(menu[0].name + " - " + toIDR(menu[0].price) + " (" + menu[0].category + ")");
      System.out.println(menu[1].name + " - " + toIDR(menu[1].price) + " (" + menu[1].category + ")");
      System.out.println(menu[2].name + " - " + toIDR(menu[2].price) + " (" + menu[2].category + ")");
      System.out.println(menu[3].name + " - " + toIDR(menu[3].price) + " (" + menu[3].category + ")");
      System.out.println(menu[4].name + " - " + toIDR(menu[4].price) + " (" + menu[4].category + ")");
    }
    if (category == null || category == Category.Minuman) {
      System.out.println("\n");
      System.out.println("--------- Minuman ---------");
      System.out.println(menu[5].name + " - " + toIDR(menu[5].price) + " (" + menu[5].category + ")");
      System.out.println(menu[6].name + " - " + toIDR(menu[6].price) + " (" + menu[6].category + ")");
      System.out.println(menu[7].name + " - " + toIDR(menu[7].price) + " (" + menu[7].category + ")");
      System.out.println(menu[8].name + " - " + toIDR(menu[8].price) + " (" + menu[8].category + ")");
      System.out.println(menu[9].name + " - " + toIDR(menu[9].price) + " (" + menu[9].category + ")");
    }
    System.out.println("\n");
  }

  // overload printOrder
  static void printOrder(int no, String[] order) {
    printOrder(no, order, false);
  }

  // cetak pesanan
  static void printOrder(int no, String[] order, boolean is_promo) {
    if (order == null) {
      return;
    }

    Menu selected_menu = findMenu(order);

    if (selected_menu == null) {
      return;
    }

    int price = selected_menu.price;
    int qty = Integer.parseInt(order[1]);
    String message_order = !is_promo ? "%s - Rp.%d x %d = %d%n" : "%d. %s - Rp.%d x %d = GRATIS%n";
    System.out.printf(no + ". " + message_order, order[0], price, qty, price * qty);
    sub_total += price * qty;
  }

  // membuat pesanan berdasarkan menu input user
  static String[] createOrder(int no) {
    System.out.printf("Masukkan menu %d: ", no);
    String[] input_order = input.nextLine().split("\\s*=\\s*");
    Menu selected_menu = findMenu(input_order);
    if (selected_menu == null) {
      return null;
    }
    return input_order;
  }

  // proses pesanan
  static void startOrder() {
    System.out.println("======== Masukkan Pesanan (Maksimal 4 menu) ========");
    System.out.print("Jumlah menu yang ingin dipesan: ");

    try {
      jumlahPesanan = Integer.parseInt(input.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Jumlah pesanan harus berupa angka.");
      return;
    }

    if (jumlahPesanan < 1 || jumlahPesanan > 4) {
      System.out.println("Pesanan harus antara 1 sampai 4 menu.\n");
      startOrder();
      return;
    }

    pesanan1 = createOrder(1);
    if (jumlahPesanan >= 2) {
      pesanan2 = createOrder(2);
    }
    if (jumlahPesanan >= 3) {
      pesanan3 = createOrder(3);
    }
    if (jumlahPesanan >= 4) {
      pesanan4 = createOrder(4);
    }

    printBill();
  }

  // list pesanan
  static void listOrder() {
    System.out.println("\n============= PESANAN =============");

    printOrder(1, pesanan1);
    if (pesanan2 != null) {
      printOrder(2, pesanan2);
    }
    if (pesanan3 != null) {
      printOrder(3, pesanan3);
    }
    if (pesanan4 != null) {
      printOrder(4, pesanan4);
    }
  }

  // show promo
  static void prosesPromo() {
    System.out.println("Anda mendapatkan promo Beli 1 Gratis 1 untuk kategori minuman! ingin mengambilnya? (y/n): ");
    String offering = input.nextLine();
    boolean take_offering = offering.equalsIgnoreCase("y");

    if (take_offering) {
      showMenu(Category.Minuman);
      System.out.println("\nSilahkan pilih menu minuman: ");
      String[] input_order = (input.nextLine() + "=1").split("\\s*=\\s*");
      Menu selected_menu = findMenu(input_order);
      if (selected_menu != null) {
        listOrder();
        printOrder(jumlahPesanan + 1, input_order);
      }
    }
  }

  // cetak struk
  static void printBill() {
    listOrder();

    // check for bonus
    if (sub_total >= 50000) {
      prosesPromo();
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
    startOrder();
  }
}