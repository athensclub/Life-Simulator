package athensclub.comproj.game;

import java.io.Serializable;

/**
 * A class representing player age
 *
 * @author Athensclub
 */
public class Age implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    private int days,months,years;

    public Age(int years){
        this.years = years;
    }

    /**
     * Update all the values,overflow 31 day to 1 month and 1 day etc.
     */
    private void updateValues(){
        if(days >= 30){
            months += days / 30;
            days = days % 30;
        }
        if(months > 12){
            years += months / 12;
            months = months % 12;
        }
    }

    public void addDays(int day){
        days += day;
        updateValues();
    }

    /**
     * Get the string representation of this age in thai language
     * @return
     */
    public String toThaiString(){
        return years + " ปี" + (months == 0 ? "" : months + " เดือน") + (days == 0 ? "" : days + " วัน");
    }

    @Override
    public String toString(){
        return toThaiString();
    }

}
