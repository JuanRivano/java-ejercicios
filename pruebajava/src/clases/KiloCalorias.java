package clases;


public class KiloCalorias {
    private String nombre;
    private int edad;
    private String sexo;
    private int caloriasConsumidasDiariamente[];

    public KiloCalorias(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.caloriasConsumidasDiariamente = llenarCaloriasConsumidas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int[] getCaloriasConsumidasDiariamente() {
        return caloriasConsumidasDiariamente;
    }

    public void setCaloriasConsumidasDiariamente(int[] caloriasConsumidasDiariamente) {
        this.caloriasConsumidasDiariamente = caloriasConsumidasDiariamente;
    }



    private int [] llenarCaloriasConsumidas(){
        int calorias[]=new int[5];
        for (int i = 0; i < calorias.length; i++) {
            //valor aleatorio entre 1000 a 4000
            calorias[i] = (int) (Math.random() * (1000-4000)+4000);
        }
        return calorias;
    }

}
