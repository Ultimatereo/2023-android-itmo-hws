# Jetpack Compose

В рамках этого домашнего задания необходимо реализовать экран со списком при помощи Jetpack Compose. Для тех, кто делает мессенджер, это список настроек, а для тех, кто делает свой проект, любой аналогичный экран со списком.

1. [Описание проекта "Мессенджер"](https://github.com/polis-vk/2023-android-itmo-hws/tree/task_7#мессенджер)
2. [Общие требования к собственному проекту](https://github.com/polis-vk/2023-android-itmo-hws/tree/task_7#свой-проект)

## Критерии оценивания домашнего задания. Jetpack Compose

Ограничения:
- Не использовать сторонние графические движки (Unity, Unreal и т.п.).
- Нужно использовать стандартные средства Android SDK и Jetpack Compose.
- Использование обычных Android View и их наследников не допускается

Если ограничения не будут соблюдены, то вы не получите баллов. Более детально требования и баллы к ним описаны ниже по пунктам. Также в некоторых случаях без этих ограничений мы просто не сможем проверить ваше задание и попросим выполнить его снова.

Требования:

1. Общие (max 2 балла)
    - Проект собирается (баллов не дает, так как без этого их не получится набрать)
    - Приложение не крашится
    - Отсутствуют утечки памяти
    - Отсутствуют лишние рекомпозиции, когда данные не изменились
    - Отсутствуют лишние сайд эффекты
    - Поддержка сохранения состояния Composable функции
    - Поддержка вертикальной и горизонтальной ориентации экрана, при повороте не должны теряться введенные данные. Блокировать поворот экрана не допускается.
    - Сами экраны и навигация могут быть реализованы как на фрагментах, так и на Compose screens

2. Экран списка настроек (max 8 баллов)
    - Тулбар с названием раздела и кнопкой "назад" (1 балл)
        - Должны быть поддержка edge-to-edge
    - Отображение списка (6 баллов)
        - Список должен быть "ленивым", его количество элементов может быть неограниченным
        - Список должен храниться за пределами @Composable функции и передаваться в нее либо через аргументы функции, либо через ViewModel
        - Должно поддерживаться эффективное кэширование списка при помощи задания key для элементов списка
        - Элементы списка в разных категориях должны отличаться (должны поддерживаться минимум 2 разные категории)
        - В каждой категории у элемента должен быть заголовок (обязательный), подзаголовок (опционален) и любой третий опциональный параметр (свитч, чекбокс, текст и тд)
        - Разные категории должны разделяться дивайдером и sticky header
        - Состояние списка должно сохраняться при перезаходе на экран (т.е. выбранные настройки должны сохраняться)
    - Отдельная кнопка "Очистить кэш" (1 балл)
        - Заголовок кнопки по стилю должна отличаться от остального списка (выбрать цвет текста можно самостоятельно)
