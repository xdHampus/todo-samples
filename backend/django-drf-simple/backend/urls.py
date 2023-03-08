from django.urls import path
from rest_framework.urlpatterns import format_suffix_patterns
from todo import views
from django.contrib import admin

urlpatterns = [
    path('admin/', admin.site.urls),
    path('todo/', views.todo_list),
    path('todo/<int:pk>/', views.todo_int),
]
urlpatterns = format_suffix_patterns(urlpatterns)
