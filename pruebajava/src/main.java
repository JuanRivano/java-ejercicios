import clases.KiloCalorias;

public class main {

    public static void main(String[] args) {

        KiloCalorias kilos = new KiloCalorias("nombre",30,"Masculino");
        for (int kilos_:kilos.getCaloriasConsumidasDiariamente()){
            System.out.println(kilos_);
        }
    }
}
