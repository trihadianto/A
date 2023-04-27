import java.util.Scanner;

public class BankQueueSimulation {
    private static final int MAX_CAPACITY = 10;
    private static final String[] queue1 = new String[MAX_CAPACITY];
    private static final String[] queue2 = new String[MAX_CAPACITY];
    private static int rear1 = -1, front1 = -1, rear2 = -1, front2 = -1;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int choice = 0;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Data Antrian");
                System.out.println("2. Hapus Antrian Elemen Pertama");
                System.out.println("3. Hapus Antrian di Posisi Tertentu");
                System.out.println("4. Hapus Semua Elemen");
                System.out.println("5. Tampilkan Data");
                System.out.println("6. Keluar");
                System.out.print("Pilihan Anda: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> enqueue(sc);
                    case 2 -> dequeue();
                    case 3 -> delete(sc);
                    case 4 -> clear();
                    case 5 -> display();
                    case 6 -> System.out.println("Terima kasih!");
                    default -> System.out.println("Pilihan tidak valid, silakan coba lagi!");
                }
            } while (choice != 6);
        }
    }

    private static void enqueue(Scanner sc) {
        System.out.print("Masukkan nama: ");
        String name = sc.next();
        System.out.print("Masukkan nomor antrian (1/2): ");
        int queueNum = sc.nextInt();
        switch (queueNum) {
            case 1:
                if (rear1 == MAX_CAPACITY - 1) {
                    System.out.println("Antrian 1 penuh, data tidak dapat ditambahkan.");
                } else {
                    if (front1 == -1) {
                        front1 = 0;
                    }
                    rear1++;
                    queue1[rear1] = name;
                    System.out.println("Data " + name + " berhasil ditambahkan ke Antrian 1.");
                }   break;
            case 2:
                if (rear2 == MAX_CAPACITY - 1) {
                    System.out.println("Antrian 2 penuh, data tidak dapat ditambahkan.");
                } else {
                    if (front2 == -1) {
                        front2 = 0;
                    }
                    rear2++;
                    queue2[rear2] = name;
                    System.out.println("Data " + name + " berhasil ditambahkan ke Antrian 2.");
                }   break;
            default:
                System.out.println("Nomor antrian tidak valid, data tidak dapat ditambahkan.");
                break;
        }
    }

    private static void dequeue() {
        if (front1 == -1 && front2 == -1) {
            System.out.println("Antrian kosong, tidak ada data yang dihapus.");
        } else {
            if (front1 != -1) {
                String name = queue1[front1];
                queue1[front1] = null;
                if (front1 == rear1) {
                    front1 = rear1 = -1;
                } else
            {
                front1++;
            }
            System.out.println("Data " + name + " dihapus dari Antrian 1.");
        } else {
            String name = queue2[front2];
            queue2[front2] = null;
            if (front2 == rear2) {
                front2 = rear2 = -1;
            } else {
                front2++;
            }
            System.out.println("Data " + name + " dihapus dari Antrian 2.");
        }
    }
}

private static void delete(Scanner sc) {
    System.out.print("Masukkan nomor antrian (1/2): ");
    int queueNum = sc.nextInt();
    System.out.print("Masukkan posisi data yang akan dihapus: ");
    int pos = sc.nextInt() - 1;
        switch (queueNum) {
            case 1:
                if (pos < front1 || pos > rear1) {
                    System.out.println("Posisi tidak valid, data tidak dapat dihapus.");
                } else {
                    String name = queue1[pos];
                    for (int i = pos; i < rear1; i++) {
                        queue1[i] = queue1[i+1];
                    }
                    queue1[rear1] = null;
                    rear1--;
                    if (front1 > rear1) {
                        front1 = rear1 = -1;
                    }
                    System.out.println("Data " + name + " dihapus dari Antrian 1.");
                }       break;
            case 2:
                if (pos < front2 || pos > rear2) {
                    System.out.println("Posisi tidak valid, data tidak dapat dihapus.");
                } else {
                    String name = queue2[pos];
                    for (int i = pos; i < rear2; i++) {
                        queue2[i] = queue2[i+1];
                    }
                    queue2[rear2] = null;
                    rear2--;
                    if (front2 > rear2) {
                        front2 = rear2 = -1;
                    }
                    System.out.println("Data " + name + " dihapus dari Antrian 2.");
                }       break;
            default:
                System.out.println("Nomor antrian tidak valid, data tidak dapat dihapus.");
                break;
        }
}

private static void clear() {
    for (int i = 0; i < MAX_CAPACITY; i++) {
        queue1[i] = null;
        queue2[i] = null;
    }
    front1 = rear1 = front2 = rear2 = -1;
    System.out.println("Semua data dihapus dari kedua antrian.");
}

private static void display() {
    System.out.println("Antrian 1:");
    if (front1 == -1) {
        System.out.println("Kosong");
    } else {
        for (int i = front1; i <= rear1; i++) {
            System.out.println((i-front1+1) + ". " + queue1[i]);
        }
    }
    System.out.println("Antrian 2:");
    if (front2 == -1) {
        System.out.println("Kosong");
    } else {
        for (int i = front2; i <= rear2; i++) {
            System.out.println((i-front2+1) + ". " + queue2[i]);
        }
    }
}
}/**
 *
 * @author Tri Hadianto 
 */
