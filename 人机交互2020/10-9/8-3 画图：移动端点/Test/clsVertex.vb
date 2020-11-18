Imports System.Math
Public Class clsVertex
    Public x As Single, y As Single
    Public selected As Boolean
    Public Shared r As Single = 5   ' 共享的半径
    Event ChangedSelected()
    Event Changed()

    Public Sub New(ByVal x As Single, ByVal y As Single)
        Me.x = x : Me.y = y
        selected = False
    End Sub

    Function IsSelect(ByVal p As PointF) As Boolean
        Dim dx As Single = Abs(p.X - x)
        Dim dy As Single = Abs(p.Y - y)
        Dim newSelected = dx + dy < 2 * r


        If newSelected = True Then
            selected = Not selected
            RaiseEvent ChangedSelected()
        End If
        Return selected
    End Function
    Sub Move(ByVal offset As Point)
        If selected = True Then
            x += offset.X : y += offset.Y
            RaiseEvent Changed()
        End If
    End Sub


    Sub Draw(ByVal g As Graphics)
        If selected Then
            g.DrawEllipse(Pens.Red, x - r, y - r, 2 * r, 2 * r)
        Else
            g.DrawEllipse(Pens.Blue, x - r, y - r, 2 * r, 2 * r)
        End If

    End Sub

End Class
