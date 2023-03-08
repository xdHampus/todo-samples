from rest_framework import status
from rest_framework.decorators import api_view
from rest_framework.response import Response
from todo.models import TodoItem
from todo.serializers import TodoItemSerializer



@api_view(['GET', 'POST'])
def todo_list(request, format=None):
    """
    List all todo-items, or create a new todo-item.
    """
    if request.method == 'GET':
        todos = TodoItem.objects.all()
        serializer = TodoItemSerializer(todos, many=True)
        return Response(serializer.data)

    elif request.method == 'POST':
        serializer = TodoItemSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

        

@api_view(['GET', 'PUT', 'DELETE'])
def todo_int(request, pk, format=None):
    """
    Read, update or delete a todo-item.
    """
    try:
        todo = TodoItem.objects.get(pk=pk)
    except TodoItem.DoesNotExist:
        return Response(status=status.HTTP_404_NOT_FOUND)

    if request.method == 'GET':
        serializer = TodoItemSerializer(todo)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = TodoItemSerializer(todo, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        todo.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)
