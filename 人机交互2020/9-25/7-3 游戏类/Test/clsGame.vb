Public Class clsGame
    Private box As clsBox
    Private ball As clsBall
    'Private balls As List(Of  clsBall)

    Public Sub New()
        box = New clsBox(200, 200, 300, 400)
        ball = New clsBall(100, 100, 5)
    End Sub

    Public Sub Draw(ByVal g As Graphics)
        ball.Draw(g)
        box.Draw(g)
    End Sub

End Class
