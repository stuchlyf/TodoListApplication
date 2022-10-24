const BASE_URL = 'http://localhost:8080'
const checkIfStatus2xx = (response) => {
    return response.status < 300 && response.status >= 200
}

const getTodos = async () => {
    const response = await fetch(`${BASE_URL}/todo-controller/todos`);
    if (checkIfStatus2xx(response)) {
        return await response.json();
    } else {
        throw new Error();
    }
}

const TODO_LIST_ELEMENT = document.querySelector('#todo-list')
getTodos().then((todos) => {
    todos.forEach((todo, i) => {
        const todoElement = document.createElement('li');
        todoElement.classList.add('todo-entry');

        const titleElement = document.createElement('h3');
        titleElement.textContent = todo.title;
        titleElement.classList.add('title');
        todoElement.append(titleElement);

        const descriptionElement = document.createElement('p');
        descriptionElement.textContent = todo.description;
        descriptionElement.classList.add('description');
        todoElement.append(descriptionElement);

        const checkboxElement = document.createElement('input');
        checkboxElement.type = 'checkbox';
        checkboxElement.classList.add('checkbox');
        checkboxElement.name = `todo-checkbox-${todo.id}`;
        checkboxElement.value = todo.completed;
        todoElement.append(checkboxElement);

        TODO_LIST_ELEMENT.append(todoElement);
    })
})