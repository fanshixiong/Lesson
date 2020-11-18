Public Class clsBall
    Private x As Single, y As Single, r As Single
    Private vx As Single, vy As Single
    Public Sub New(ByVal x As Single, ByVal y As Single, ByVal r As Single, ByVal vx As Single, ByVal vy As Single)
        Me.x = x : Me.y = y : Me.r = r
        Me.vx = vx : Me.vy = vy
    End Sub

    Public Sub Draw(ByVal g As Graphics)
        g.DrawEllipse(Pens.Black, x - r, y - r, 2 * r, 2 * r)
    End Sub

    Sub Move(ByVal box As clsBox)
        x += vx : y += vy
        If x + r >= box.Right Then vx = -vx
        If x - r <= box.Left Then vx = -vx
        If y + r > box.Bottom Then vy = -vy
        If y - r <= box.Top Then vy = -vy
    End Sub

End Class
