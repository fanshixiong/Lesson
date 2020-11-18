Imports System.Math
Public Class clsVertex
    Public x As Single, y As Single
    Public Shared r As Single = 5   ' 共享的半径

    Public Sub New(ByVal x As Single, ByVal y As Single)
        Me.x = x : Me.y = y
    End Sub
    Function IsSelect(ByVal p As PointF) As Boolean
        Dim dx As Single = abs(p.X - x)
        Dim dy As Single = Abs(p.Y - y)
        Return dx + dy < 2 * r
    End Function

    Sub Draw(ByVal g As Graphics)
        g.DrawEllipse(Pens.Red, x - r, y - r, 2 * r, 2 * r)
    End Sub

End Class
