/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relojdigital;

/**
 *
 * @author Samuel A
 */
public class ClockDisplay 
{
    /**
     * La clase ClockDisplay implementa una pantalla de reloj digital para un
     * reloj de 24 horas, estilo europeo. El reloj muestra las horas y los
     * minutos. El rango del reloj es de 00:00 (medianoche) a 23:59 (un minuto
     * antes de la medianoche).
     *
     * La pantalla del reloj recibe "pulsos" (a través del método timeTick) cada
     * minuto y reacciona incrementando la pantalla. Esto se hace de la forma
     * habitual en los relojes: la hora se incrementa cuando los minutos pasan
     * de nuevo a cero.
     *
     * @author Michael Kölling y David J. Barnes
     * @version 2016.02.29
     */
    
      private NumberDisplay hours;
        private NumberDisplay minutes;
        private String displayString; // simula la pantalla real

        /**
         * Constructor para los objetos ClockDisplay. Este constructor crea un
         * nuevo reloj inicializado con 00:00.
         */
        public ClockDisplay() {
            hours = new NumberDisplay(12);
            minutes = new NumberDisplay(60);
            updateDisplay();
        }

        /**
         * Constructor para los objetos ClockDisplay. Este constructor crea un
         * nuevo reloj inicializado con la hora especificada mediante los
         * parámetros.
         */
        public ClockDisplay(int hour, int minute) {
            hours = new NumberDisplay(12);
            minutes = new NumberDisplay(60);
            setTime(hour, minute);
        }
        
       
        /**
         * Este método debe invocarse una vez cada minuto - hace que la pantalla
         * del reloj avance un minuto.
         */
        public void timeTick() {
            minutes.increment();
            if (minutes.getValue() == 0) { // ¡ha vuelto a cero!
                hours.increment();
            }
            updateDisplay();
        }

        /**
         * Fija la hora de la pantalla con la hora y los minutos especificados.
         */
        public void setTime(int hour, int minute) {
            hours.setValue(hour);
            minutes.setValue(minute);
            updateDisplay();
        }

        /**
         * Devuelve la hora actual de esta pantalla en el formato HH:MM.
         */
        public String getTime() {
            return displayString;
        }

        /**
         * Actualiza la cadena interna que representa la pantalla.
         */
        private void updateDisplay() {
            
            int hourValue = hours.getValue();
            
            if(hourValue == 0){
                displayString = "12:" + minutes.getDisplayValue();
            }else{
                displayString = hours.getDisplayValue()+ ":" + minutes.getDisplayValue();
            }
            
            
        }
        
        public void setTime(String time) {
        String[] partes = time.split(":");
        int h = Integer.parseInt(partes[0]);
        int m = Integer.parseInt(partes[1]);

        hours.setValue(h);
        minutes.setValue(m);

        updateDisplay();
        
        
        
   
    }

}
