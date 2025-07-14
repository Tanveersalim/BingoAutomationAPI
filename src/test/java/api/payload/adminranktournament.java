package api.payload;

public class adminranktournament {
	

	private int percentage;
    private String name;
    private String shortCode;
    private Rewards rewards;

    public static class Rewards {
        private int tickets;
        private int powerUps;

        public int getTickets() {
            return tickets;
        }

        public void setTickets(int tickets) {
            this.tickets = tickets;
        }

        public int getPowerUps() {
            return powerUps;
        }

        public void setPowerUps(int powerUps) {
            this.powerUps = powerUps;
        }
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public Rewards getRewards() {
        return rewards;
    }

    public void setRewards(Rewards rewards) {
        this.rewards = rewards;
    }
}