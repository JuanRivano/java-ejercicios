package clases;



public class KiloCalorias {
    private String nombre;
    private int edad;
    private String sexo;
    private int[]   caloriasConsumidasDiariamente;


    public KiloCalorias(String nombre, int edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.caloriasConsumidasDiariamente = llenarCaloriasConsumidas();
    }
//***************constructor para pruebas*************************
    public KiloCalorias(String nombre, int edad, String sexo, int[] caloriasConsumidasDiariamente) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.caloriasConsumidasDiariamente = caloriasConsumidasDiariamente;
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
        int[] calorias =new int[5];
        for (int i = 0; i < calorias.length; i++) {
            //valor aleatorio entre 1000 a 4000
            calorias[i] = (int) (Math.random() * (1000-4000)+4000);
        }
        return calorias;
    }

    public double gastoMetabolismoBasal(double peso){
        double gastoBasal=0;
        if (sexo.toLowerCase().equals("hombre")){
            gastoBasal=(edad<50)?24:21.6;
        }else if(sexo.toLowerCase().equals("mujer")){
            gastoBasal=(edad<50)?21.6:19.2;
        }
        return gastoBasal*1.1*peso;
    }

    public double gastoActividadFisica(String intensidad,double peso){
        double gastoBasal=gastoMetabolismoBasal(peso);
        switch (intensidad.toLowerCase()){
            case "sedentaria":
                return 0.30*gastoBasal;
            case "moderada":
                return 0.60*gastoBasal;
            case "intensa":
                return 0.90*gastoBasal;
            default:
                System.out.println("error en intecidad");
                break;
        }
        return 0;
    }

    public double caloriasDiariasTotales(double peso,String intensidad){
        return gastoMetabolismoBasal(peso) + gastoActividadFisica(intensidad,peso);
    }

    public String[] estado(String[] intensidad,double[]peso){
        String [] estados=new String[5];
        long caloriasDiarias=0;
        for(int i=0;i<intensidad.length;i++){
            caloriasDiarias=Math.round(caloriasDiariasTotales(peso[i],intensidad[i]));
            if(caloriasConsumidasDiariamente[i]>caloriasDiarias){
                estados[i]="Engorda";
            }else if(caloriasConsumidasDiariamente[i]<caloriasDiarias){
                estados[i]="Adelgaza";
            }else if (caloriasConsumidasDiariamente[i]==caloriasDiarias){
                estados[i]="Mantiene";
            }
        }
        return estados;
    }

    public void mostrarInformacion(){
        System.out.println("El nombre de la persona "+nombre);
        System.out.println("La edad de la persona "+edad);
        System.out.println("El sexo de la persona "+sexo);
        imprimirCalorias();
    }


    public void imprimirCalorias(){
        for (int i=0;i<caloriasConsumidasDiariamente.length;i++){
            System.out.println("El conumo diario para el dia "+diasDeLaSemana(i)+" es "+caloriasConsumidasDiariamente[i]);
        }
    }

    public String diasDeLaSemana(int dia){
        switch (dia){
            case 0:
                return "Lunes";
            case 1:
                return "Martes";
            case 2:
                return "Miercoles";
            case 3:
                return "Jueves";
            case 4:
                return "Viernes";

        }
        return "Error dia semana";
    }
}
