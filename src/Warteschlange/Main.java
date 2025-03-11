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

/**
 * Hauptklasse zum Testen der Funktionalität der Warteschlange.
 */
public class Main {
    public static void main(String[] args) {
        Warteschlange<String> warteschlange = new Warteschlange<>();
        
        // Elemente zur Warteschlange hinzufügen
        warteschlange.enqueue("Kunde 1");
        warteschlange.enqueue("Kunde 2");
        warteschlange.enqueue("Kunde 3");
        warteschlange.ausgabe(); // Ausgabe: Kunde 1, Kunde 2, Kunde 3

        // Erstes Element entfernen
        warteschlange.dequeue();
        warteschlange.ausgabe(); // Ausgabe: Kunde 2, Kunde 3

        // Erstes Element entfernen
        warteschlange.dequeue();
        warteschlange.ausgabe(); // Ausgabe: Kunde 3

        // Erstes Element entfernen
        warteschlange.dequeue();
        warteschlange.ausgabe(); // Ausgabe: Die Warteschlange ist leer!
    }
}