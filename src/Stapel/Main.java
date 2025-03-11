/*
 * This file is part of Facharbeit: Q1.4: Höhere Datenstrukturen.
 *
 * Facharbeit: Q1.4: Höhere Datenstrukturen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Facharbeit: Q1.4: Höhere Datenstrukturen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Facharbeit: Q1.4: Höhere Datenstrukturen. If not, see <https://www.gnu.org/licenses/>.
 *
 * Author: Marko Livajusic
 * Email: marko.livajusic4 <at> gmail.com
 * Copyright: (C) 2025 Marko Livajusic
 */

public class Main {
    /**
     * Hauptmethode zum Testen der Funktionalität des Stapels.
     * Es werden mehrere Bücher auf den Stapel gelegt, der Stapel wird ausgegeben,
     * ein Buch wird entfernt, und das oberste Buch wird angezeigt.
     *
     * @param args Kommandozeilenargumente (werden nicht verwendet).
     */
    public static void main(String[] args) {
        Stapel<String> buecherStapel = new Stapel<>();
        System.out.println(buecherStapel.laenge());

        buecherStapel.push("Woyzeck"); // Fügt "Woyzeck" hinzu
        buecherStapel.push("Faust I"); // Fügt "Faust I" hinzu
        buecherStapel.push("Faust II"); // Fügt "Faust II" hinzu
        buecherStapel.ausgeben(); // Gibt den Stapel aus

        buecherStapel.pop(); // Entfernt das oberste Element ("Faust II")
        buecherStapel.ausgeben(); // Gibt den aktualisierten Stapel aus

        System.out.println(buecherStapel.peek()); // Gibt das neue oberste Element ("Faust I") aus
    }

}