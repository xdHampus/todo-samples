from django.urls import path

from . import views


urlpatterns = [
    path('all', views.getAll, name='getAll'),
    path('<int:id>', views.TodoIntParamView.as_view(), name='todoIntParamView'),
    path('', views.TodoRequestBodyView.as_view(), name='todoRequestBodyView'),
]
