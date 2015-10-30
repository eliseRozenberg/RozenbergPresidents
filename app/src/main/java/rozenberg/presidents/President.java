package rozenberg.presidents;

/**
 * Created by Elise on 10/22/2015.
 */
public class President {
    private int number;
    private String president;
    private int birthYear;
    private Integer deathYear;     //becuase obama = null
    private String tookOffice;
    private String leftOffice;
    private String party;

    public int getNumber() {
        return number;
    }

    public String getPresident() {
        return president;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public String getTookOffice() {
        return tookOffice;
    }

    public String getLeftOffice() {
        return leftOffice;
    }

    public String getParty() {
        return party;
    }
}
