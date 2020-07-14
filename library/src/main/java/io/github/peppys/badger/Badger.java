package io.github.peppys.badger;

class Badger {
    public static void main(String[] args) {
        Badge badge = Badge.builder()
                .setLabelColor("black")
                .setLabelText("label")
                .setMessageColor("black")
                .setMessageText("ok")
                .build();

        System.out.println(badge.toString());

        System.out.println("SVG: " + badge.getRawSVG());
    }
}
