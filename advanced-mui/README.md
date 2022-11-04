# TodoListApplication (Advanced-MUI)

## Aufgaben

### 1. Erstellen eines 'simplen' Backends CRUD Methoden

- [ ] Erstellen einer API mit:
  - [ ] Einer Methode um alle Todos zu bekommen
  - [ ] Einer Methode um ein einziges Todo mit einer bestimmten ID zu bekommen
  - [ ] Einer Methode um ein neues Todo anzulegen
  - [ ] Einer Methode um ein bereits bestehendes Todo zu bearbeiten
  - [ ] Einer Methode um ein Todo zu löschen
- [ ] Außerdem sollen Todos in verschiedene 'Buckets' unterteilt werden können ([Bild](https://techcommunity.microsoft.com/t5/image/serverpage/image-id/167968i07CFF3B59E0EF132/image-dimensions/698x445?v=v2))
- [ ] Erstellung eines Persistence Layers mit
  - [ ] Einem `TodoEntryEty`-Entity
  - [ ] Einem `TodoEntryRepository`
- [ ] Nutzung des `Mapstruct`-Mappers

### 2. Erstellen eines 'simplen' Frontends

- [ ] Erstellen der Grundlage mit `vite`
  - Framework: React
  - Variant: TypeScript
- [ ] Hinzufügen dieser Dependencies
  - [ ] `react-router-dom@6`
  - [ ] `@tanstack/react-query`
  - [ ] `@mui/material`
  - [ ] `@emotion/react`
  - [ ] `@emotion/styled`

### 3. Advanced

- [ ] Außerdem soll es eine Methode geben um nach Todos zu suchen
  - [ ] Implementation eines simplen Such-Algorithmus indem nur gefiltert wird ob der Titel des Todos das eingegebene Schlüsselwort enthalten
  - [ ] Später auch suche in der Beschreibung des Todos
