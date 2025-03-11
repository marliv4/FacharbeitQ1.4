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

public class Knoten<T> {
    private T           m_Daten;
    private Knoten<T>   m_Nachfolger;

    public Knoten() {
        m_Daten         = null;
        m_Nachfolger    = null;
    }

    public Knoten(T daten) {
        m_Daten         = daten;
        m_Nachfolger    = null;
    }

    public Knoten(T daten, Knoten<T> nachfolger) {
        m_Daten         = daten;
        m_Nachfolger    = nachfolger;
    }

    public T getDaten() {
        return m_Daten;
    }

    public Knoten<T> getNachfolger() {
        return m_Nachfolger;
    }

    public void setDaten(T daten) {
        m_Daten = daten;
    }

    public void setNachfolger(Knoten<T> nachfolger) {
        m_Nachfolger = nachfolger;
    }

}
