import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Club {
    private String name;
    private String type;
    private String meetingDays;
    private String meetingTimes;
    private boolean hasAudition;
    private String clubLeader;
    private String contact;
    private String description;
    private static Club[] myClubs = new Club[]{};

    private static final Set<String> VALID_TYPES = new HashSet<>(Arrays.asList(
            "Dance", "Sports", "Chemistry", "Math", "Art", "Music", "Theater"
    ));

    private static final Set<String> VALID_DAYS = new HashSet<>(Arrays.asList(
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
    ));

    public Club(String name, String type, String meetingDays, String meetingTimes, boolean hasAudition, String clubLeader,
                String description ,String contact) {
        if (!isValidType(type)) {
            throw new IllegalArgumentException("Invalid club type: " + type);
        }
        if (!isValidMeetingDays(meetingDays)) {
            throw new IllegalArgumentException("Invalid meeting days: " + meetingDays);
        }

        this.name = name;
        this.type = type;
        this.meetingDays = meetingDays;
        this.meetingTimes = meetingTimes;
        this.hasAudition = hasAudition;
        this.clubLeader = clubLeader;
        this.contact = contact;
        this.description = description;
    }

    private boolean isValidType(String type) {
        return VALID_TYPES.contains(type);
    }

    private boolean isValidMeetingDays(String meetingDays) {
        String[] days = meetingDays.split(",");
        for (String day : days) {
            if (!VALID_DAYS.contains(day.trim())) {
                return false;
            }
        }
        return true;
    }

    // Accessor methods
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getMeetingDays() {
        return meetingDays;
    }

    public String getMeetingTimes() {
        return meetingTimes;
    }

    public boolean hasAudition() {
        return hasAudition;
    }

    public String getClubLeader() {
        return clubLeader;
    }

    public String getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    public static Club[] getMyClubs() {
        return myClubs;
    }

    public static void addtomyClub(Club club) {
        myClubs = Arrays.copyOf(myClubs, myClubs.length + 1);
        myClubs[myClubs.length - 1] = club;
    }
}

