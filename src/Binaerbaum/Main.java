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

class BinaerBaum<T extends Comparable<T>> {
    private Knoten<T> m_Wurzel;

    public BinaerBaum() {
        m_Wurzel = new Knoten<>();
    }

    public BinaerBaum(T daten) {
        m_Wurzel = new Knoten<>(daten);
    }

    public Knoten<T> getWurzel() {
        return m_Wurzel;
    }

    /**
     * Fügt einen neuen Knoten mit dem gegebenen Wert rekursiv in den binären Suchbaum ein.
     *
     * @param wurzel Die Wurzel des (Teil-)Baums, in den der neue Knoten eingefügt wird.
     * @param wert   Der Wert, der in den Baum eingefügt werden soll.
     * @return Die Wurzel des aktualisierten Baums.
     */
    public Knoten<T> insert(Knoten<T> wurzel, T wert) {
        // Basisfall: Wenn der aktuelle Knoten null ist, erstelle einen neuen Knoten.
        if (wurzel == null) {
            return new Knoten<>(wert);
        }

        // Vergleich: Füge den Wert in den linken oder rechten Teilbaum ein.
        if (wert.compareTo(wurzel.getDaten()) < 0) {
            // Der Wert ist kleiner als der aktuelle Knoten (füge ihn links ein).
            wurzel.setLinks(insert(wurzel.getLinks(), wert));
        } else if (wert.compareTo(wurzel.getDaten()) > 0) {
            // Der Wert ist größer als der aktuelle Knoten (füge ihn rechts ein).
            wurzel.setRechts(insert(wurzel.getRechts(), wert));
        }

        // Gib die (unveränderte) Wurzel zurück.
        return wurzel;
    }

    /**
     * Löscht einen Knoten mit dem gegebenen Wert rekursiv aus dem binären Suchbaum.
     *
     * @param wurzel Die Wurzel des (Teil-)Baums, aus dem der Knoten gelöscht werden soll.
     * @param wert   Der Wert, der gelöscht werden soll.
     * @return Die Wurzel des aktualisierten Baums.
     */
    public Knoten<T> loeschen(Knoten<T> wurzel, T wert) {
        // Basisfall: Wenn der aktuelle Knoten null ist, gibt es nichts zu löschen.
        if (wurzel == null) {
            return null;
        }

        // Vergleich: Finde den zu löschenden Knoten.
        if (wert.compareTo(wurzel.getDaten()) < 0) {
            // Der Wert ist kleiner als der aktuelle Knoten, d.h. man sucht im linken Teilbaum.
            wurzel.setLinks(loeschen(wurzel.getLinks(), wert));
        } else if (wert.compareTo(wurzel.getDaten()) > 0) {
            // Der Wert ist größer als der aktuelle Knoten, d.h. sucht im rechten Teilbaum.
            wurzel.setRechts(loeschen(wurzel.getRechts(), wert));
        } else {
            // Der Wert wurde gefunden, d.h. lösche den Knoten.

            // Fall 1: Der Knoten hat kein oder nur ein Kind.
            if (wurzel.getLinks() == null) {
                return wurzel.getRechts(); // Gib das rechte Kind zurück (kann null sein).
            } else if (wurzel.getRechts() == null) {
                return wurzel.getLinks(); // Gib das linke Kind zurück.
            }

            // Fall 2: Der Knoten hat zwei Kinder.
            // Finde den kleinsten Wert im rechten Teilbaum (Nachfolger).
            Knoten<T> nachfolger = findeMin(wurzel.getRechts());
            // Ersetze den Wert des aktuellen Knotens durch den Wert des Nachfolgers.
            wurzel.setDaten(nachfolger.getDaten());
            // Lösche den Nachfolger aus dem rechten Teilbaum.
            wurzel.setRechts(loeschen(wurzel.getRechts(), nachfolger.getDaten()));
        }

        // Gib die (möglicherweise aktualisierte) Wurzel zurück.
        return wurzel;
    }

    /**
     * Hilfsmethode, um den kleinsten Wert im Baum zu finden.
     *
     * @param knoten Der Knoten, ab dem gesucht wird.
     * @return Der Knoten mit dem kleinsten Wert.
     */
    private Knoten<T> findeMin(Knoten<T> knoten) {
        // Gehe so weit wie möglich nach links, um den kleinsten Wert zu finden.
        while (knoten.getLinks() != null) {
            knoten = knoten.getLinks();
        }
        return knoten;
    }

    /**
     * Aktualisiert den Wert eines Knotens im binären Suchbaum.
     *
     * @param wurzel Die Wurzel des Baums.
     * @param alterWert Der zu ersetzende Wert.
     * @param neuerWert Der neue Wert.
     * @return Die Wurzel des aktualisierten Baums.
     */
    public Knoten<T> aktualisieren(Knoten<T> wurzel, T alterWert, T neuerWert) {
        // 1. Lösche den Knoten mit dem alten Wert.
        wurzel = loeschen(wurzel, alterWert);

        // 2. Füge den neuen Wert in den Baum ein.
        wurzel = insert(wurzel, neuerWert);

        // Gib die aktualisierte Wurzel zurück.
        return wurzel;
    }

    /**
     * Führt eine Preorder-Traversierung des Baums durch.
     * Preorder besucht zuerst die Wurzel, dann den linken Teilbaum und schließlich den rechten Teilbaum.
     *
     * @param k Der aktuelle Knoten, bei dem die Traversierung beginnt.
     */
    public void preorder(Knoten<T> k) {
        // Basisfall: Wenn der Knoten null ist, beende die Rekursion.
        if (k == null) return;

        // 1. Besuche die Wurzel (aktueller Knoten).
        System.out.println(k.getDaten());

        // 2. Durchlaufe den linken Teilbaum rekursiv.
        preorder(k.getLinks());

        // 3. Durchlaufe den rechten Teilbaum rekursiv.
        preorder(k.getRechts());
    }

    /**
     * Führt eine Inorder-Traversierung des Baums durch.
     * Inorder durchläuft zuerst den linken Teilbaum, dann die Wurzel und schließlich den rechten Teilbaum.
     * Bei einem binären Suchbaum gibt dies die Knoten in aufsteigender Reihenfolge aus.
     *
     * @param k Der aktuelle Knoten, bei dem die Traversierung beginnt.
     */
    public void inorder(Knoten<T> k) {
        // Basisfall: Wenn der Knoten null ist, beende die Rekursion.
        if (k == null) return;

        // 1. Durchlaufe den linken Teilbaum rekursiv.
        inorder(k.getLinks());

        // 2. Besuche die Wurzel (aktueller Knoten).
        System.out.println(k.getDaten());

        // 3. Durchlaufe den rechten Teilbaum rekursiv.
        inorder(k.getRechts());
    }

    /**
     * Führt eine Postorder-Traversierung des Baums durch.
     * Postorder durchläuft zuerst den linken Teilbaum, dann den rechten Teilbaum und schließlich die Wurzel.
     * Dies wird oft verwendet, um einen Baum zu löschen, da die Kinder vor ihren Eltern besucht werden.
     *
     * @param k Der aktuelle Knoten, bei dem die Traversierung beginnt.
     */
    public void postorder(Knoten<T> k) {
        // Basisfall: Wenn der Knoten null ist, beende die Rekursion.
        if (k == null) return;

        // 1. Durchlaufe den linken Teilbaum rekursiv.
        postorder(k.getLinks());

        // 2. Durchlaufe den rechten Teilbaum rekursiv.
        postorder(k.getRechts());

        // 3. Besuche die Wurzel (aktueller Knoten).
        System.out.println(k.getDaten());
    }
}

public class Main {
    public static void main(String[] args) {
        // Erstelle einen binären Suchbaum mit der Wurzel 20.
        BinaerBaum<Integer> b = new BinaerBaum<>(20);

        // Füge weitere Knoten in den Baum ein.
        b.insert(b.getWurzel(), 10);
        b.insert(b.getWurzel(), 30);
        b.insert(b.getWurzel(), 5);
        b.insert(b.getWurzel(), 15);
        b.insert(b.getWurzel(), 25);
        b.insert(b.getWurzel(), 35);

        // Gib den Baum in Inorder-Reihenfolge aus (aufsteigend sortiert).
        System.out.println("Inorder-Traversierung (vor Aktualisierung und Löschen):");
        b.inorder(b.getWurzel());
        System.out.println();

        // Aktualisiere den Wert 15 auf 18.
        System.out.println("Aktualisiere den Wert 15 auf 18:");
        b.aktualisieren(b.getWurzel(), 15, 18);
        b.inorder(b.getWurzel());
        System.out.println();

        // Lösche den Wert 10.
        System.out.println("Lösche den Wert 10:");
        b.loeschen(b.getWurzel(), 10);
        b.inorder(b.getWurzel());
        System.out.println();

        // Gib den Baum in Preorder-Reihenfolge aus.
        System.out.println("Preorder-Traversierung:");
        b.preorder(b.getWurzel());
        System.out.println();

        // Gib den Baum in Postorder-Reihenfolge aus.
        System.out.println("Postorder-Traversierung:");
        b.postorder(b.getWurzel());
        System.out.println();
    }
}