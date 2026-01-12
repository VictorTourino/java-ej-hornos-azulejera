/*
 * Programa: E125_matricesHornosAzulejera
 * Autor: Víctor Touriño Fernández
 * Curso: 1º DAM
 * Fecha: 15/11/2025
 *
 * Programa en Java por consola para almacenar y analizar las temperaturas
 * de 3 hornos industriales durante 365 días del año.
 *
 * Se calculan medias, valores máximos y mínimos, diferencias entre días
 * laborables y fines de semana, así como medias por meses concretos.
 */

import java.util.Scanner;

public class E125_matricesHornosAzulejera {
    public static Scanner sc = new Scanner(System.in);
 
    //Definimos todos los colores que iremos usando durante el programa.
    public static final String NORMAL = "\u001B[0m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String MORADO = "\u001B[35m";
    public static final String AZUL = "\u001B[36m";

    public static int[] horno1 = new int[365]; 
    public static int[] horno2 = new int[365]; 
    public static int[] horno3 = new int[365];

    public static void main(String[] args) {
     
        
        inicializarVector(horno1);
        inicializarVector(horno2);
        inicializarVector(horno3);

        mostrarMenu();




        
        
    }

    public static void inicializarVector(int[] horno){

        for(int i = 0; i < horno.length; i++){
        horno[i] = (int) (Math.random() * 201) + 700; //Genera valores aleatorios entre 700 y 900      
        }

    }


    public static void mostrarMenu(){

        int seleccion;

        borrarConsola();
        System.out.println(AZUL +"|------------------------------------------|" + "\n|       PROGRAMA TEMPERATURA HORNOS        |" + "\n|------------------------------------------|");

        System.out.println(VERDE + "1.- " + AMARILLO + "Mostrar datos de todo el año.");
        System.out.println(VERDE + "2.- " + AMARILLO + "Mostrar media de temperatura de los hornos.");
        System.out.println(VERDE + "3.- " + AMARILLO + "Mostrar maximo y minimo y sus correspondientes dias.");
        System.out.println(VERDE + "4.- " + AMARILLO + "Mostrar medias entresemana y fines de semana.");
        System.out.println(VERDE + "5.- " + AMARILLO + "Mostrar media de: Febrero, Marzo, Abril y Mayo.");
        System.out.println(VERDE + "6.- " + AMARILLO + "Cambiar dato de algún dia.");
        System.out.println(VERDE + "7.- " + AMARILLO + "Salir");
        System.out.println("\n" + NORMAL + "Por favor, introduzca una opción:");

        seleccion = sc.nextInt();

        switch (seleccion) {
            case 1: mostrarDatos();
                break;
            case 2: mostrarMediaTemperatura();
                break;
            case 3: mostrarMaximoYMinimoYDias();
                break;
            case 4: mostrarMediaEntreSemanaYFinDeSemana();
                break;
            case 5: mostrarMediaFbrMrzAbrMyo();
                break;
            case 6: cambiarDato();
                break;
            case 7: System.out.println(ROJO + "Saliendo del programa... ¡Hasta pronto!" + NORMAL); 
                break;
            default: System.out.println(ROJO + "Error! Vuelva a ejecutar el programa e introduzca la respuesta correctamente." + NORMAL);
                System.out.println("Presione enter para continuar.");
                sc.nextLine();                  
                sc.nextLine();
                mostrarMenu();
                break;
        }


    }

    public static void mostrarDatos(){
        int seleccion;
        System.out.println(AZUL +"|-----------------------------|" + "\n|       DATOS ANUALES         |" + "\n|-----------------------------|");
        System.out.println(MORADO + "¿De que horno desea ver los datos?");
        System.out.println(VERDE + "1.-" + NORMAL + " Horno 1" + VERDE + "\n2.-" + NORMAL + " Horno 2" + VERDE + "\n3.-" + NORMAL + " Horno 3" + NORMAL);
        seleccion = sc.nextInt();

        switch (seleccion) {
            case 1: mostrarDatosCompletos(horno1);
                break;
            case 2: mostrarDatosCompletos(horno2);
                break;
            case 3: mostrarDatosCompletos(horno3);
                break;
        
            default: System.out.println(ROJO + "Error! Vuelva a ejecutar el programa e introduzca la respuesta correctamente." + NORMAL);
                System.out.println("Presione enter para continuar.");
                sc.nextLine();                  
                sc.nextLine();
                mostrarMenu();
                break;
        }
        


    }

    public static void mostrarDatosCompletos(int [] horno){

        System.out.println(AZUL +"|----------------------------------|" + "\n|       DATOS ANUALES HORNO        |" + "\n|----------------------------------|");
                        // Recorremos los 12 meses del año (1 = enero, 12 = diciembre)

        for(int i = 1; i<13; i++){//Bucle que recorre los meses

            if(i == 1){
                System.out.println(AMARILLO +"\n\n|------------------|" + "\n|       ENERO      |" + "\n|------------------|");
                
                for(int enr = 0; enr<30; enr++){//Dentro hay bucles que cada uno recorre e imprime un mes, con sus correspondientes dias encima (LUNES(L) MARTE(M) MIERCOLES(X) JUEVES(J) VIERNES(V) SABADO(S) Y DOMINGO(D))
                    if (enr == 0){
                        System.out.println(MORADO + " L    M    X    J    V    S    D" + NORMAL);
                    }
                    System.out.print(horno[enr] + ", ");
                    if ((enr + 1) % 7 == 0){
                        System.out.print("\n");
                    }
                }
            }

            if(i == 2){
                System.out.println(AMARILLO +"\n\n|--------------------|" + "\n|       FEBRERO      |" + "\n|--------------------|");
            
                for(int fbr= 31; fbr>30 && fbr<58; fbr++){
                    if (fbr == 31){
                        System.out.println(MORADO + " X    J    V    S    D    L    M" + NORMAL);
                    }
                    System.out.print(horno[fbr] + ", ");
                    if ((fbr + 5) % 7 == 0){
                        System.out.print("\n");
                    }

                }
            }
            if(i==3){
                System.out.println(AMARILLO +"\n\n|------------------|" + "\n|       MARZO      |" + "\n|------------------|");
                for(int mrz= 59; mrz>58 &&mrz<89; mrz++){
                    if (mrz == 59){
                        System.out.println(MORADO + " M    X    J    V    S    D    L" + NORMAL);
                    }
                    System.out.print(horno[mrz] + ", ");
                    if ((mrz + 5) % 7 == 0){
                        System.out.print("\n");
                    }
    
    
                }


            }

            if(i==4){
                System.out.println(AMARILLO +"\n\n|------------------|" + "\n|       ABRIL      |" + "\n|------------------|");
                for(int abr = 90; abr>89 && abr<119; abr++){
                    if (abr == 90){
                        System.out.println(MORADO + " J    V    S    D    L    M    X" + NORMAL);
                    }
                    System.out.print(horno[abr] + ", ");
                    if ((abr+2) % 7 == 0){
                        System.out.print("\n");
                    }
    
                }


            }

            if(i==5){
                System.out.println(AMARILLO +"\n\n|-----------------|" + "\n|       MAYO      |" + "\n|-----------------|");

                for(int myo = 120; myo>119 && myo<150; myo++){
                    if (myo == 120){
                        System.out.println(MORADO + " V    S    D    L    M    X    J" + NORMAL);
                    }
                    System.out.print(horno[myo] + ", ");
                    if ((myo) % 7 == 0){
                        System.out.print("\n");
                    }
    
                }

            }

            if(i==6){
                System.out.println(AMARILLO +"\n\n|------------------|" + "\n|       JUNIO      |" + "\n|------------------|");
                for(int jno = 151; jno>150 && jno<180; jno++){
                    if (jno == 151){
                        System.out.println(MORADO + " D    L    M    X    J    V    S" + NORMAL);
                    }
                    System.out.print(horno[jno] + ", ");
                    if ((jno + 4) % 7 == 0){
                        System.out.print("\n");
                    }
    
                }


            }

            if(i==7){
                System.out.println(AMARILLO +"\n\n|------------------|" + "\n|       JULIO      |" + "\n|------------------|");
                for(int jlo = 181; jlo>180 && jlo< 211; jlo++){
                    if (jlo == 181){
                        System.out.println(MORADO + " L    M    X    J    V    S    D" + NORMAL);
                    }
                    System.out.print(horno[jlo] + ", ");
                    if ((jlo + 2) % 7 == 0){
                        System.out.print("\n");
                    }
    
                }


            }

            if(i == 8){
                System.out.println(AMARILLO +"\n\n|-------------------|" + "\n|       AGOSTO      |" + "\n|-------------------|");
                for(int agt = 212; agt>211 && agt<242; agt++){
                    if (agt == 212){
                        System.out.println(MORADO + " X    J    V    S    D    L    M" + NORMAL);
                    }
                    System.out.print(horno[agt] + ", ");
                    if ((agt + 6) % 7 == 0){
                        System.out.print("\n");
                    }
    
    
    
                }



            }

            if(i == 9){
                System.out.println(AMARILLO +"\n\n|-----------------------|" + "\n|       SEPTIEMBRE      |" + "\n|-----------------------|");
                for(int spt = 243; spt>242 && spt<272; spt++){
    
                    if (spt == 243){
                        System.out.println(MORADO + " V    S    D    L    M    X    J" + NORMAL);
                    }
                    System.out.print(horno[spt] + ", ");
                    if ((spt + 3) % 7 == 0){
                        System.out.print("\n");
                    }
    
                }


            }

            if(i == 10){
                System.out.println(AMARILLO +"\n\n|--------------------|" + "\n|       OCTUBRE      |" + "\n|--------------------|");
                for(int oct = 273; oct>272 && oct<303; oct++){
                    if (oct == 273){
                        System.out.println(MORADO + " S    D    L    M    X    J    V" + NORMAL);
                    }
                    System.out.print(horno[oct] + ", ");
                    if ((oct + 1) % 7 == 0){
                        System.out.print("\n");
                    }
    
    
                }



            }

            if ( i == 11){
                System.out.println(AMARILLO +"\n\n|----------------------|" + "\n|       NOVIEMBRE      |" + "\n|----------------------|");
                for(int nov = 304; nov>303 && nov<333; nov++){
    
                    if (nov == 304){
                        System.out.println(MORADO + " L    M    X    J    V    S    D" + NORMAL);
                    }
                    System.out.print(horno[nov] + ", ");
                    if ((nov + 5) % 7 == 0){
                        System.out.print("\n");
                    }
    
    
                }
                

            }
            
            if ( i == 12){
                System.out.println(AMARILLO +"\n\n|----------------------|" + "\n|       DICIEMBRE      |" + "\n|----------------------|");

                for(int dic = 334; dic>333 && dic<364; dic++){
                    if (dic == 334){
                        System.out.println(MORADO + " M    X    J    V    S    D    L" + NORMAL);
                    }
                    System.out.print(horno[dic] + ", ");
                    if ((dic + 3) % 7 == 0){
                        System.out.print("\n");
                    }
    
                }

            }
            
        }
        System.out.println("\nPresione enter para continuar.");
        sc.nextLine();                  
        sc.nextLine();
        mostrarMenu();
    
    }

    public static void mostrarMediaTemperatura(){
        int seleccion;
        System.out.println(AZUL +"|---------------------------------|" + "\n|       MEDIA TEMPERATURA         |" + "\n|---------------------------------|");
        System.out.println(MORADO + "¿De que horno desea ver la media de su temperatura anual?");
        System.out.println(VERDE + "1.-" + NORMAL + " Horno 1" + VERDE + "\n2.-" + NORMAL + " Horno 2" + VERDE + "\n3.-" + NORMAL + " Horno 3" + NORMAL);
        seleccion = sc.nextInt();

        switch (seleccion) {
            case 1: mostrarMediaTemperaturaCompleto(horno1);
                break;
            case 2: mostrarMediaTemperaturaCompleto(horno2);
                break;
            case 3: mostrarMediaTemperaturaCompleto(horno3);
                break;
        
            default: System.out.println(ROJO + "Error! Vuelva a ejecutar el programa e introduzca la respuesta correctamente." + NORMAL);
                System.out.println("Presione enter para continuar.");
            sc.nextLine();                  
            sc.nextLine();
            mostrarMenu();
                break;
        }
        


    }

    public static void mostrarMediaTemperaturaCompleto(int[] horno){
        System.out.println(AZUL +"|---------------------------------|" + "\n|       MEDIA TEMPERATURA         |" + "\n|---------------------------------|");
        
        int mediaTemp = 0;
        
        for(int i=0; i<horno.length; i++){
            
            mediaTemp += horno[i];
            
        }
        
        System.out.println(AMARILLO + "\n*********************************************************" + MORADO + "\nLa media de temperatura del horno seleccionado es de " + ROJO + (mediaTemp/horno.length) + MORADO + " grados." + AMARILLO + "\n*********************************************************"+ NORMAL);
        System.out.println("Presione enter para continuar.");
        sc.nextLine();                  
        sc.nextLine();                 
        mostrarMenu();
    }

    public static void borrarConsola() {

        System.out.print("\033[2J");
        System.out.flush();
    }


    public static void mostrarMediaFbrMrzAbrMyo(){
        int seleccion;
        System.out.println(AZUL +"|-------------------------------------------------------|" + "\n|             MEDIA FEBRERO MARZO ABRIL MAYO            |" + "\n|-------------------------------------------------------|");
        System.out.println(MORADO + "¿De que horno desea ver la media de su temperatura de los meses de " + VERDE + "FEBRERO, MARZO, ABRIL Y MAYO?");
        System.out.println(VERDE + "1.-" + NORMAL + " Horno 1" + VERDE + "\n2.-" + NORMAL + " Horno 2" + VERDE + "\n3.-" + NORMAL + " Horno 3" + NORMAL + VERDE + "\n4.-"+ NORMAL + " Los tres" + NORMAL);
        seleccion = sc.nextInt();

        switch (seleccion) {
            case 1: mostrarMediaFbrMrzAbrMyoCompleto(horno1);
                break;
            case 2: mostrarMediaFbrMrzAbrMyoCompleto(horno2);
                break;
            case 3: mostrarMediaFbrMrzAbrMyoCompleto(horno3);
                break;
            case 4: mostrarMediaFbrMrzAbrMyoCompleto3HORNOS(horno1, horno2, horno3);
                break;
        
            default: System.out.println(ROJO + "Error! Vuelva a ejecutar el programa e introduzca la respuesta correctamente." + NORMAL);
                System.out.println("Presione enter para continuar.");
            sc.nextLine();                  
            sc.nextLine();
            borrarConsola();
            mostrarMenu();
                break;
        }


    }

    public static void mostrarMediaFbrMrzAbrMyoCompleto(int [] horno){
        System.out.println(AZUL +"|-------------------------------------------------------|" + "\n|             MEDIA FEBRERO MARZO ABRIL MAYO            |" + "\n|-------------------------------------------------------|");

        int mediaTempFebreroAMayo = 0;

        for(int i=31; i<150; i++){//Ponemos i=31 porque es donde empieza febrero, en el horno[31], y ponemos de final el ultimo dia de mayo, que es el indice 150.
            
            mediaTempFebreroAMayo += horno[i];
            
        }

        System.out.println(AMARILLO + "\n*********************************************************" + MORADO + "\nLa media de temperatura del horno seleccionado durante los meses de " + VERDE + "FEBRERO, MARZO, ABRIL Y MAYO" + MORADO +" es de " + ROJO + (mediaTempFebreroAMayo/(150-31)) + MORADO + " grados." + AMARILLO + "\n*********************************************************"+ NORMAL);
        System.out.println("Presione enter para continuar.");
        sc.nextLine();                  
        sc.nextLine();
        //borrarConsola();                  
        mostrarMenu();


    }

    public static void mostrarMediaFbrMrzAbrMyoCompleto3HORNOS(int [] horno1, int[]horno2, int[]horno3){
        System.out.println(AZUL +"|-------------------------------------------------------|" + "\n|             MEDIA FEBRERO MARZO ABRIL MAYO            |" + "\n|-------------------------------------------------------|");

        int mediaTempFebreroAMayo = 0;

        for(int i=31; i<150; i++){
            
            mediaTempFebreroAMayo += horno1[i];
            
        }
        for(int i=31; i<150; i++){
            
            mediaTempFebreroAMayo += horno2[i];
            
        }
        for(int i=31; i<150; i++){
            
            mediaTempFebreroAMayo += horno3[i];
            
        }

        System.out.println(AMARILLO + "\n*********************************************************" + MORADO + "\nLa media de temperatura de los tres hornos durante los meses de " + VERDE + "FEBRERO, MARZO, ABRIL Y MAYO" + MORADO +" es de " + ROJO + (mediaTempFebreroAMayo/((150-31) * 3)) + MORADO + " grados." + AMARILLO + "\n*********************************************************"+ NORMAL);
        System.out.println("Presione enter para continuar.");
        sc.nextLine();                  
        sc.nextLine();
        //borrarConsola();                  
        mostrarMenu();
    }

    public static void mostrarMaximoYMinimoYDias(){
        int seleccion;
        System.out.println(AZUL +"|----------------------------------------|" + "\n|             MAXIMO Y MINIMO            |" + "\n|----------------------------------------|");
        System.out.println(MORADO + "¿De que horno desea ver su temperatura maxima y minima junto a sus dia correspondientes?");
        System.out.println(VERDE + "1.-" + NORMAL + " Horno 1" + VERDE + "\n2.-" + NORMAL + " Horno 2" + VERDE + "\n3.-" + NORMAL + " Horno 3" + NORMAL);
        seleccion = sc.nextInt();

        switch (seleccion) {
            case 1: mostrarMaximoYMinimoYDiasCompleto(horno1);
                break;
            case 2: mostrarMaximoYMinimoYDiasCompleto(horno2);
                break;
            case 3: mostrarMaximoYMinimoYDiasCompleto(horno3);
                break;
            default: System.out.println(ROJO + "Error! Vuelva a ejecutar el programa e introduzca la respuesta correctamente." + NORMAL);
                System.out.println("Presione enter para continuar.");
            sc.nextLine();                  
            sc.nextLine();
            mostrarMenu();
                break;
        }
    }
    public static void mostrarMaximoYMinimoYDiasCompleto(int [] horno){
    int maximo = 0, minimo = 0;
    String diaminimo = "", diamaximo ="";
        for (int i = 0; i < horno.length; i++){
            if (i == 0) {
                maximo = horno[0];
                minimo = horno[0];
            }
            maximo = Math.max(horno[i], maximo);
            minimo = Math.min(horno[i], minimo);
            if (i == horno.length - 1){
                System.out.println("La maxima temperatura que dicho horno ha logrado han sido " + AMARILLO + maximo + NORMAL + " grados.");
                System.out.println("La minima temperatura que dicho horno ha logrado han sido " + AMARILLO + minimo + NORMAL + " grados.");
                for (int j = 0; j < horno.length; j++){
                    if (horno[j] == minimo){
                        diaminimo = (j+1) + ", ";
                    }else if (horno[j] == maximo){
                        diamaximo += (j+1) + ", ";

                    }
                }
                System.out.println("\nHa llegado a la temperatura minima " + AMARILLO + "(" + minimo + ")" + NORMAL + " los siguientes dias: " +VERDE + diaminimo + NORMAL);
                System.out.println("\nHa llegado a la temperatura maxima " + AMARILLO + "(" + maximo + ")" + NORMAL + " los siguientes dias: " +VERDE + diamaximo + NORMAL);
                System.out.println("\nPresione enter para continuar.");
                sc.nextLine();                  
                sc.nextLine();
                borrarConsola();                  
                mostrarMenu();
            }
        }
    }
    public static void mostrarMediaEntreSemanaYFinDeSemana() {
        int seleccion;
        System.out.println(AZUL +"|-------------------------------------------------------------|" + "\n|             MEDIA ENTRE SEMANA Y FINES DE SEMANA            |" + "\n|-------------------------------------------------------------|");
        System.out.println(MORADO + "¿De que horno desea ver la media de su temperatura entre semana (Lunes-Viernes) y los fines de semana (Sabado y Domingo) de todo el año?");
        System.out.println(VERDE + "1.-" + NORMAL + " Horno 1" + VERDE + "\n2.-" + NORMAL + " Horno 2" + VERDE + "\n3.-" + NORMAL + " Horno 3" + NORMAL);
        seleccion = sc.nextInt();

        switch (seleccion) {
            case 1: mostrarMediaEntreSemanaYFinDeSemanaCompleto(horno1);
                break;
            case 2: mostrarMediaEntreSemanaYFinDeSemanaCompleto(horno2);
                break;
            case 3: mostrarMediaEntreSemanaYFinDeSemanaCompleto(horno3);
                break;
            default: System.out.println(ROJO + "Error! Vuelva a ejecutar el programa e introduzca la respuesta correctamente." + NORMAL);
                System.out.println("Presione enter para continuar.");
            sc.nextLine();                  
            sc.nextLine();
            mostrarMenu();
                break;
        }
    }

    public static void mostrarMediaEntreSemanaYFinDeSemanaCompleto(int [] horno){
        int diasEntreSemana = 0, diasFinesDeSemana = 0, diaDeLaSemana = 0;
        int temperaturaEntreSemana = 0, temperaturaFinesDeSemana=0;

        for(int i = 0; i<horno.length; i++){

            diaDeLaSemana = i % 7; //Calculamos el día de la semana (0 = lunes, 5-6 = fin de semana)

            if (diaDeLaSemana < 5){
                temperaturaEntreSemana += horno[i];
                diasEntreSemana++;
            }else {
                temperaturaFinesDeSemana += horno[i];
                diasFinesDeSemana++;

            }
        }

    

        System.out.println(AMARILLO + "\n*********************************************************" + MORADO + "\nLa media de temperatura del horno seleccionado durante todo el año " + VERDE + "ENTRE SEMANA" + MORADO +" es de " + ROJO + (temperaturaEntreSemana / diasEntreSemana) + MORADO + " grados." + AMARILLO + "\n*********************************************************"+ NORMAL);//Dividimos la temperatura total entre los dias que se han sumado en el bucle para tener la media. En este caso entre semana.
        System.out.println(AMARILLO + "\n*********************************************************" + MORADO + "\nLa media de temperatura del horno seleccionado durante todo el año los " + VERDE + "FINES DE SEMANA" + MORADO +" es de " + ROJO + (temperaturaFinesDeSemana/ diasFinesDeSemana) + MORADO + " grados." + AMARILLO + "\n*********************************************************"+ NORMAL);//Aqui es el de FINES DE SEMANA.
        System.out.println("Presione enter para continuar.");
        sc.nextLine();                  
        sc.nextLine();
        borrarConsola();                  
        mostrarMenu();

    }

    public static void cambiarDato(){
        int seleccion;
        System.out.println(AZUL +"|-------------------------------------|" + "\n|             CAMBIAR DATO            |" + "\n|-------------------------------------|");
        System.out.println(MORADO + "¿De que horno desea cambiar algun dato?");
        System.out.println(VERDE + "1.-" + NORMAL + " Horno 1" + VERDE + "\n2.-" + NORMAL + " Horno 2" + VERDE + "\n3.-" + NORMAL + " Horno 3" + NORMAL);
        seleccion = sc.nextInt();

        switch (seleccion) {
            case 1: cambiarDatoCompleto(horno1);
                break;
            case 2: cambiarDatoCompleto(horno2);
                break;
            case 3: cambiarDatoCompleto(horno3);
                break;
            default: System.out.println(ROJO + "Error! Vuelva a ejecutar el programa e introduzca la respuesta correctamente." + NORMAL);
                System.out.println("Presione enter para continuar.");
            sc.nextLine();                  
            sc.nextLine();
            mostrarMenu();
                break;
        }

    }

    public static void cambiarDatoCompleto(int [] horno){
        int nuevovalordia, nuevovalortemp;

        System.out.println("¿De que dia quiere cambiar el valor de la temperatura?");
        nuevovalordia = sc.nextInt();
        System.out.println("¿Que temperatura desea asignarle a dicho dia?");
        nuevovalortemp = sc.nextInt();


        horno[nuevovalordia-1] = nuevovalortemp;//A nuevovalordia le restamos 1 ya que los indices van del 0 al 364, pero para el usuario un año normal va desde el dia 1 al 365.

        System.out.println(VERDE + "NUEVO VALOR ASIGNADO");
        System.out.println(NORMAL +"\nSe ha asignado la temperatura de " + MORADO + nuevovalortemp + NORMAL+" grados en el dia " + MORADO +nuevovalordia +NORMAL +" del año.");


        System.out.println("\nPresione enter para continuar.");
        sc.nextLine();                  
        sc.nextLine();
        borrarConsola();                  
        mostrarMenu();
    }

}

