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

import java.util.ArrayList;

/**
 * Eine Implementierung eines Stapels (Stack) mit einer ArrayList.
 * Ein Stapel ist eine Datenstruktur, die nach dem LIFO-Prinzip (Last In, First Out) arbeitet.
 * Das bedeutet, dass das zuletzt hinzugefügte Element als erstes wieder entfernt wird.
 *
 * @param <T> Der Typ der Elemente, die im Stapel gespeichert werden.
 */
public class Stapel<T> {
    private ArrayList<T> m_Liste; // Die interne Liste, die den Stapel repräsentiert

    /**
     * Konstruktor, der einen leeren Stapel erstellt.
     * Die interne ArrayList wird initialisiert.
     */
    public Stapel() {
        m_Liste = new ArrayList<>();
    }

    /**
     * Fügt ein neues Element oben auf den Stapel hinzu.
     * Das Element wird am Ende der ArrayList hinzugefügt.
     *
     * @param daten Das Element, das auf den Stapel gelegt werden soll.
     */
    public void push(T daten) {
        m_Liste.add(daten);
    }

    /**
     * Entfernt das oberste Element vom Stapel.
     * Das Element wird vom Ende der ArrayList entfernt.
     * Wenn der Stapel leer ist, wird eine IndexOutOfBoundsException ausgelöst.
     */
    public void pop() {
        if (leer()) {
            throw new IndexOutOfBoundsException("Der Stapel ist leer!");
        }
        final var top = m_Liste.size() - 1; // Index des obersten Elements
        m_Liste.remove(top); // Entfernt das oberste Element
    }

    /**
     * Gibt das oberste Element zurück, ohne es zu entfernen.
     * Das Element wird vom Ende der ArrayList abgerufen.
     *
     * @return Das oberste Element des Stapels.
     * @throws IndexOutOfBoundsException Wenn der Stapel leer ist.
     */
    public T peek() {
        if (leer()) {
            throw new IndexOutOfBoundsException("Der Stapel ist leer!");
        }
        return m_Liste.get(m_Liste.size() - 1); // Gibt das oberste Element zurück
    }

    /**
     * Gibt alle Elemente des Stapels auf der Konsole aus.
     * Die Elemente werden von unten nach oben ausgegeben, gefolgt von einer Trennlinie.
     */
    public void ausgeben() {
        for (T element : m_Liste) {
            System.out.println(element); // Gibt jedes Element aus
        }
        System.out.println("-------"); // Trennlinie
    }

    public int laenge() {
        return m_Liste.size();
    }

    public boolean leer() {
        return laenge() == 0;
    }
}