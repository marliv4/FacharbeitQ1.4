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
 * Eine Klasse, die einen Knoten in einem binären Baum repräsentiert.
 * Jeder Knoten enthält Daten sowie Referenzen auf seinen linken und rechten Kindknoten.
 *
 * @param <T> Der Typ der Daten, die im Knoten gespeichert werden.
 */
public class Knoten<T> {
    private T m_Daten; // Die Daten, die im Knoten gespeichert werden
    private Knoten<T> m_Links; // Referenz auf den linken Kindknoten
    private Knoten<T> m_Rechts; // Referenz auf den rechten Kindknoten

    /**
     * Standardkonstruktor, der einen leeren Knoten erstellt.
     * Die Daten sowie die linken und rechten Kindknoten sind null.
     */
    public Knoten() {
        m_Daten = null;
        m_Links = null;
        m_Rechts = null;
    }

    /**
     * Konstruktor, der einen Knoten mit den angegebenen Daten erstellt.
     * Die linken und rechten Kindknoten sind null.
     *
     * @param daten Die Daten, die im Knoten gespeichert werden sollen.
     */
    public Knoten(T daten) {
        m_Daten = daten;
        m_Links = null;
        m_Rechts = null;
    }

    /**
     * Konstruktor, der einen Knoten mit den angegebenen Daten sowie linken und rechten Kindknoten erstellt.
     *
     * @param daten Die Daten, die im Knoten gespeichert werden sollen.
     * @param links Der linke Kindknoten.
     * @param rechts Der rechte Kindknoten.
     */
    public Knoten(T daten, Knoten<T> links, Knoten<T> rechts) {
        m_Daten = daten;
        m_Links = links;
        m_Rechts = rechts;
    }

    /**
     * Gibt die Daten des Knotens zurück.
     *
     * @return Die Daten des Knotens.
     */
    public T getDaten() {
        return m_Daten;
    }

    /**
     * Gibt den linken Kindknoten zurück.
     *
     * @return Der linke Kindknoten.
     */
    public Knoten<T> getLinks() {
        return m_Links;
    }

    /**
     * Gibt den rechten Kindknoten zurück.
     *
     * @return Der rechte Kindknoten.
     */
    public Knoten<T> getRechts() {
        return m_Rechts;
    }

    /**
     * Setzt die Daten des Knotens.
     *
     * @param daten Die neuen Daten, die im Knoten gespeichert werden sollen.
     */
    public void setDaten(T daten) {
        this.m_Daten = daten;
    }

    /**
     * Setzt den linken Kindknoten.
     *
     * @param links Der neue linke Kindknoten.
     */
    public void setLinks(Knoten<T> links) {
        m_Links = links;
    }

    /**
     * Setzt den rechten Kindknoten.
     *
     * @param rechts Der neue rechte Kindknoten.
     */
    public void setRechts(Knoten<T> rechts) {
        m_Rechts = rechts;
    }
}