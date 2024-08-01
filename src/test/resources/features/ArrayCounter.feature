Feature: Array Counter

  Scenario: Подсчет элементов в массиве
    Given входящая строка "1,3,4,5,1,5,4"
    When я считаю элементы
    Then результат должен быть:
      | Element | Count |
      | 1       | 2     |
      | 3       | 1     |
      | 4       | 2     |
      | 5       | 2     |

  Scenario: Подсчет элементов в массиве
    Given входящая строка "  1, 2, 3, 4,  1,    2,  1   "
    When я считаю элементы
    Then результат должен быть:
      | Element | Count |
      | 1       | 3     |
      | 2       | 2     |
      | 3       | 1     |
      | 4       | 1     |

  Scenario: Подсчет элементов в массиве
    Given входящая строка "apple, banana, orange, apple, apple, orange"
    When я считаю элементы
    Then результат должен быть:
      | Element | Count |
      | apple   | 3     |
      | orange  | 2     |
      | banana  | 1     |

  Scenario: Empty input string
    Given входящая строка ""
    When я считаю элементы
    Then результат должен быть пустым

  Scenario: Empty input string
    Given входящая строка " , ,,"
    When я считаю элементы
    Then результат должен быть пустым