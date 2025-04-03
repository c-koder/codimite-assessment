import java.util.ArrayList;
import java.util.List;

class Main {
    // Codimite ASE Assessment
    public static void main(String[] args) {
        String[][] availableSlot = {
                { "09:00", "10:30" },
                { "11:00", "12:40" },
                { "12:00", "12:40" }
        };

        int meetingDuration = 60;

        List<String[]> validSlots = findAvailableSlots(availableSlot, meetingDuration);

        System.out.println("Slots:");
        for (String[] time : validSlots) {
            System.out.println(time[0] + " - " + time[1]);
        }
    }

    // check for duration is enough within the time range given
    public static List<String[]> findAvailableSlots(String[][] avSlots, int meetingDuration) {
        List<String[]> validSlots = new ArrayList<>();

        for (String[] slot : avSlots) {

            int start = convertToMinutes(slot[0]);
            int end = convertToMinutes(slot[1]);

            if ((end - start) >= meetingDuration) {
                validSlots.add(slot);
            }
        }

        return validSlots;
    }

    // minute conversion
    public static int convertToMinutes(String time) {
        String[] chars = time.split(":");
        int hours = Integer.parseInt(chars[0]);
        int minutes = Integer.parseInt(chars[1]);

        return hours * 60 + minutes;
    }
}