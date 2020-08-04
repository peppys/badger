package io.github.peppys.badger;

class Badger {
    public static void main(String[] args) {
        try {
            Badge badge = Badge.builder()
                    .setLabelColor("green")
                    .setLabelText("Commits")
                    .setMessageColor("black")
                    .setMessageText("100/hr")
                    .build();

            System.out.println(badge.render());
        } catch (Exception err) {
            System.out.println("Found error" + err.toString());
        }
    }
}
