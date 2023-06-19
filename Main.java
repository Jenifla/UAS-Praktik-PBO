// Mendefinisikan Class Person sebagai superclass abstrak
abstract class Person {
    protected String nama; // atribut name yang bertipe String dan bermodifier protected

    // Konstruktor kelas Person yang menerima parameter nama
    public Person(String nama) {
        this.nama = nama;
    }

    // Metode abstrak displayInfo() yang harus diimplementasikan oleh subclass Person
    public abstract void displayInfo();
}

// Class CustomException yang merupakan custom exception
class CustomException extends Exception {
    public CustomException(String message) { //  Exception akan dilempar saat terjadi kesalahan
        super(message);
    }
}

// Class Mahasiswa sebagai subclass dari Person
class Mahasiswa extends Person {
    private String NIM; // atribut NIM yang bertipe String dan bermodifier private

    // Konstruktor kelas Mahasiswa yang menerima parameter nama dan NIM
    public Mahasiswa(String nama, String NIM) {
        // Nama diperoleh dari superclass Person dengan keyword super
        super(nama);
        this.NIM= NIM;
    }

    // Metode yang menerima parameter course dan mencetak pesan kesalahan
    public void registerCourse(String course) throws CustomException {
        // Jika course null program akan mencetak pesan kesalahan
        if (course == null || course.isEmpty()) {
            throw new CustomException("Error: Mahasiswa gagal mendaftar kursus. Nama kursus tidak valid.");
        }
        // Proses pendaftaran course
        System.out.println("Mahasiswa " + nama + " telah berhasil mendaftar kursus " + course);
    }

    // Metode override dari superclass Person dengan mencetak informasi nama mahasiswa dan NIM
    @Override
    public void displayInfo() {
        System.out.println("Nama Mahasiswa: " + nama);
        System.out.println("NIM: " + NIM);
    }

    // Getter untuk memperoleh NIM
    public String getNIM() {
        return NIM;
    }

    // setter untuk set nilai NIM
    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

}

// Class Dosen sebagai subclass dari Person
final class Dosen extends Person {
    // Atribut tambahan NIP yang menyimpan nomor induk pegawai dosen.
    private String NIP;

    // Konstruktor yang menerima parameter name dan NIP
    public Dosen(String nama, String NIP) {
        // Nama diperoleh dari superclass Person dengan keyword super
        super(nama);
        this.NIP = NIP;
    }

    // Metode yang menerima objek Mahasiswa, course, dan grade dan mencetak pesan kesalahan
    public void gradeStudent(Mahasiswa mahasiswa, String course, double grade) throws CustomException {
        // Jika nilai grade yang diberika kurang dari 0 atau lebih dari 100 program akan mencetak pesan kesalahan
        if (grade < 0 || grade > 100) {
            throw new CustomException("Error: Penilaian mahasiswa tidak valid. Nilai harus berada dalam rentang 0-100.");
        }
        // Proses memberikan nilai pada mahasiswa
        System.out.println("Dosen " + nama + " memberikan nilai " + grade + " kepada mahasiswa dengan NIM " + mahasiswa.getNIM()
                + " untuk kursus " + course);
    }


    // Metode override dari superclass Person dengan mencetak informasi nama dosen dan NIP.
    @Override
    public void displayInfo() {
        System.out.println("Nama Dosen: " + nama);
        System.out.println("NIP: " + NIP);
    }

    // Getter untuk memperoleh NIP
    public String getNIP() {
        return NIP;
    }

    // Setter untuk set nilai NIP
    public void setNIP(String NIP) {
        this.NIP = NIP;
    }
}

// Class Main untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat objek Mahasiswa
        Mahasiswa mahasiswa = new Mahasiswa("Jeni Fla N", "V392202");
        
        // memanggil metode displayInfo() untuk menampilkan informasi mahasiswa.
        mahasiswa.displayInfo();

        // Menggunakan getter dan setter pada objek Mahasiswa
        mahasiswa.setNIM("V3922024");
        System.out.println("Edit NIM Mahasiswa: " + mahasiswa.getNIM());

        System.out.println("----------------------");

        // Membuat objek Dosen
        Dosen dosen = new Dosen("Galih Putra", "1928765463");
        
        // memanggil metode displayInfo() untuk menampilkan informasi dosen.
        dosen.displayInfo();

        // Menggunakan getter dan setter pada objek Dosen
        dosen.setNIP("17286939");
        System.out.println("Edit NIP Dosen: " + dosen.getNIP());

        System.out.println("----------------------");


        // Penggunaan exception pada Mahasiswa
        try {
            // Membuat objek Mahasiswa
            Mahasiswa mahasiswa2 = new Mahasiswa("Lee Jeno", "V3922112");
            // Memanggil metode registerCourse() pada objek mahasiswa2, dan mengatur parameter course dengan nilai string kosong.
            mahasiswa2.registerCourse("");
        } catch (CustomException e) {
            // Mencetak exception 
            System.out.println(e.getMessage());
        }

        System.out.println("----------------------");

        // Penggunaan exception pada Dosen
        try {
            // Membuat objek dosen
            Dosen dosen2 = new Dosen("Quary Ty", "1982374627");
            // Membuat objek Mahasiswa
            Mahasiswa mahasiswa3 = new Mahasiswa("Zayyan M", "V3922201");
            // Memanggil metode gradeStudent() pada objek dosen2 
            dosen2.gradeStudent(mahasiswa3, "Python Programming", 95); // Memberi nilai pada objek mahasiswa3 untuk nama kursun dengan grade yang valid
            dosen2.gradeStudent(mahasiswa3, "Sistem Operasi", 110); // Memberi nilai pada objek mahasiswa3 untuk nama kursun dengan grade yang tidak valid
        } catch (CustomException e) {
            // Mencetak exception 
            System.out.println(e.getMessage());
        }
    }
}
